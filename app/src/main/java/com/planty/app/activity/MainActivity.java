package com.planty.app.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.planty.app.R;
import com.planty.app.customclass.CustomAppCompatActivity;

import com.planty.app.fragments.FragmentOtpCall;
import com.planty.app.fragments.main.FragmentHomeFeed;
import com.planty.app.fragments.main.FragmentOffer;
import com.planty.app.fragments.main.FragmentSupport;
import com.planty.app.fragments.main.webgame;
import com.planty.app.fragments.plant_list;
import com.planty.app.model.NavigationModel;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends CustomAppCompatActivity {

    LinearLayout home_ly, search_ly, offer_ly, support_ly;
    ImageView home_iv, search_iv, offer_iv, support_iv, cart_iv;
//    TextView home_tv, search_tv, offer_tv, support_tv;
    private DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    LayoutInflater inflater;
    DrawerAdapter navDrawerAdapter;
    RelativeLayout cart_ly;
    static Context mctx;

    final public static int NAV_MY_PROFILE = 1;
    final public static int NAV_MY_ORDER = 2;
    final public static int NAV_MY_RETURN = 3;
    final public static int NAV_MY_CART = 4;
    final public static int NAV_INVITE = 5;
    final public static int NAV_CONTACT_US = 6;
    final public static int NAV_TERMS_OF_USE = 7;
    final public static int NAV_DELIVERY_CHARGES_ = 8;
    final public static int NAV_NOTIFICATION = 9;
    final public static int NAV_CHECK_UPDATES = 10;
    final public static int NAV_ABOUT_US = 11;
    final public static int NAV_LOGOUT = 12;


    final public static int FRAGMENT_HOME_FEED = 1;
    final public static int FRAGMENT_SEARCH = 2;
    final public static int FRAGMENT_OFFERS = 3;
    public static String encoded_string, image_name;
    private static Bitmap bitmap;


    private static File file;
    public static Uri file_uri;
    final public static int FRAGMENT_SUPPORT = 4;

    public int FRAGMENT_CURRENT = FRAGMENT_HOME_FEED;


    Boolean refresh = false;
    public static Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        getIntents();
        initializeViews();
        setUpValues();
        setUpListeners();


    }


    public void getIntents() {

    }

    public void initializeViews() {

        activity = MainActivity.this;

        mctx = MainActivity.this;
        home_ly = findViewById(R.id.home_ly);
        search_ly = findViewById(R.id.search_ly);
        offer_ly = findViewById(R.id.offer_ly);
        support_ly = findViewById(R.id.support_ly);

        home_iv = findViewById(R.id.home_iv);
        search_iv = findViewById(R.id.search_iv);
        offer_iv = findViewById(R.id.offer_iv);
        support_iv = findViewById(R.id.support_iv);

//        home_tv = findViewById(R.id.home_tv);
//        search_tv = findViewById(R.id.search_tv);
//        offer_tv = findViewById(R.id.offer_tv);
//        support_tv = findViewById(R.id.support_tv);
//
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);


        inflater = getLayoutInflater();


    }

    public void setUpValues() {


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentHomeFeed fragmentHomeFeed = new FragmentHomeFeed();
        fragmentTransaction.add(R.id.fragment_activity_1, fragmentHomeFeed, FragmentHomeFeed.class.getSimpleName());
        fragmentTransaction.commit();


//        home_iv.setColorFilter(Constants.color_selected, PorterDuff.Mode.SRC_IN);
//        home_tv.setTextColor(Constants.color_selected);


        navDrawerAdapter = new DrawerAdapter(MainActivity.this, getNavigationModelList());
        mDrawerList.setAdapter(navDrawerAdapter);

    }


    public void setUpListeners() {


        home_ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpFooterTabs(FRAGMENT_HOME_FEED);
            }
        });
        search_ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpFooterTabs(FRAGMENT_SEARCH);
            }
        });
        offer_ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpFooterTabs(FRAGMENT_OFFERS);
            }
        });
        support_ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpFooterTabs(FRAGMENT_SUPPORT);
            }
        });


//        (findViewById(R.id.burger_menu)).setOnClickListener(new View.OnClickListener() {
//   +         @Override
//            public void onClick(View v) {
//                drawerContral();
//            }
//        });



    }


    public void setUpFooterTabs(final int tab_to_set) {
        setUpFooterTabs(tab_to_set, false);
    }

    public void setUpFooterTabs(final int tab_to_set, final Boolean proceed_refresh) {

        Log.e("foot_Tab_to", "===" + tab_to_set + "==");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (tab_to_set != FRAGMENT_CURRENT || refresh) {

            Boolean isFront = FRAGMENT_CURRENT < tab_to_set;
            FRAGMENT_CURRENT = tab_to_set;

            if (!proceed_refresh) {
                if (isFront)
                    fragmentTransaction.setCustomAnimations(R.anim.fragmententering_oncreate, R.anim.fragmentleaveing_oncreate);
                else
                    fragmentTransaction.setCustomAnimations(R.anim.fragmententering_onfinish, R.anim.fragmentleaving_onfinish);
            }

//
//            home_iv.setColorFilter(Constants.color_deselected, PorterDuff.Mode.SRC_IN);
//            search_iv.setColorFilter(Constants.color_deselected, PorterDuff.Mode.SRC_IN);
//            offer_iv.setColorFilter(Constants.color_deselected, PorterDuff.Mode.SRC_IN);
//            support_iv.setColorFilter(Constants.color_deselected, PorterDuff.Mode.SRC_IN);
//
//            home_tv.setTextColor(Constants.color_deselected);
//            offer_tv.setTextColor(Constants.color_deselected);
//            search_tv.setTextColor(Constants.color_deselected);
//            support_tv.setTextColor(Constants.color_deselected);


            switch (tab_to_set) {

                case FRAGMENT_HOME_FEED:

//                    home_iv.setColorFilter(Constants.color_selected, PorterDuff.Mode.SRC_IN);
//                    home_tv.setTextColor(Constants.color_selected);
//
//                    plant_list fragmentMenu = new plant_list();
//                    fragmentTransaction.replace(R.id.fragment_activity_1, fragmentMenu, FragmentHomeFeed.class.getSimpleName());


                    webgame fragmentMenu = new webgame();
                    fragmentTransaction.replace(R.id.fragment_activity_1, fragmentMenu);

                       break;

                case FRAGMENT_SEARCH:

//                    search_iv.setColorFilter(Constants.color_selected, PorterDuff.Mode.SRC_IN);
//                    search_tv.setTextColor(Constants.color_selected);

//                    FragmentSearch fragmentSearch = new FragmentSearch();
//                    fragmentTransaction.replace(R.id.fragment_activity_1, fragmentSearch, FragmentSearch.class.getSimpleName());

                    Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.koddev.chatapp");
                    if (launchIntent != null) {
                        startActivity(launchIntent);//null pointer check in case package name was not found
                    }



                    break;

                case FRAGMENT_OFFERS:

//                    offer_iv.setColorFilter(Constants.color_selected, PorterDuff.Mode.SRC_IN);
//                    offer_tv.setTextColor(Constants.color_selected);

                    FragmentOffer fragmentOffer = new FragmentOffer();
                    fragmentTransaction.replace(R.id.fragment_activity_1, fragmentOffer, FragmentOffer.class.getSimpleName());

                    break;
                case FRAGMENT_SUPPORT:

//                    support_iv.setColorFilter(Constants.color_selected, PorterDuff.Mode.SRC_IN);
//                    support_tv.setTextColor(Constants.color_selected);

                    FragmentSupport FragmentSupportfragmentSupport = new FragmentSupport();
                    plant_list fragmentSupport = new plant_list();
                    fragmentTransaction.replace(R.id.fragment_activity_1, fragmentSupport, FragmentSupport.class.getSimpleName());

                    break;


            }

            fragmentTransaction.commit();


        }

    }


    class DrawerAdapter extends BaseAdapter {
        Context context;
        ArrayList<NavigationModel> naviModels;

        public DrawerAdapter(Context context, ArrayList<NavigationModel> naviModelArrayList) {
            this.context = context;
            this.naviModels = naviModelArrayList;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {


            Log.e("getView: ", position + "====");
            if (position == 0) {
                convertView = inflater.inflate(R.layout.item_header_navigation, null);
//
//
            } else {
//
                final NavigationModel navigationModel = naviModels.get(position - 1);
                convertView = inflater.inflate(R.layout.item_content_navi, null);
                ImageView iv = convertView.findViewById(R.id.iv);
//                convertView = inflater.inflate(R.layout.item_app_version, null);
//                TextView app_version_tv = convertView.findViewById(R.id.app_version_tv);
//                app_version_tv.setText(CommonMethods.getAppVersion(MainActivity.this));

//
                TextView nav_title_tv = convertView.findViewById(R.id.nav_title_tv);
                LinearLayout divider_ly = convertView.findViewById(R.id.divider_ly);
                if (navigationModel.nav_title.equals("Return Product") || navigationModel.nav_title.equals("Sign Out")) {
                    divider_ly.setVisibility(View.VISIBLE);
                } else {
                    divider_ly.setVisibility(View.GONE);
                }


//
//                if (navigationModel.nav_title.equals("My Return") || navigationModel.nav_title.equals("Sign Out")) {
//                    divider_ly.setVisibility(View.VISIBLE);
//                } else {
//                    divider_ly.setVisibility(View.GONE);
//                }

                iv.setImageResource(navigationModel.nav_image_id);
                nav_title_tv.setText(navigationModel.nav_title);

                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("onClick: ", navigationModel.nav_title + "===" + position);
                        sideNavProceed(position);
                    }
                });
            }

            return convertView;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return 0;
        }

        @Override
        public int getCount() {
            return naviModels.size() + 1;
        }
    }

    public ArrayList<NavigationModel> getNavigationModelList() {

        ArrayList<NavigationModel> navigationModels = new ArrayList<NavigationModel>();
        navigationModels.add(new NavigationModel(R.drawable.home, "Home"));


        return navigationModels;

    }


    public void sideNavProceed(int sideposition) {
        switch (sideposition) {

            case 1:
                startActivity(new Intent(getApplicationContext(), com.planty.app.activity.plant_list.class));
                break;
            case 2:
                startActivity(new Intent(getApplicationContext(), com.planty.app.activity.plant_list.class));
                break;
            case NAV_MY_RETURN:

                break;
            case NAV_MY_CART:
                break;
            case NAV_INVITE:
                sendInvites();
                break;
            case NAV_CONTACT_US:
                break;
            case NAV_TERMS_OF_USE:
                break;
            case NAV_DELIVERY_CHARGES_:
                break;
            case NAV_NOTIFICATION:
                break;
            case NAV_CHECK_UPDATES:
                break;
            case NAV_ABOUT_US:
                break;
            case NAV_LOGOUT:
                break;


        }


    }


    public void logOutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Logout");
        builder.setMessage("Are you sure want Logout ?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {


                dialog.dismiss();

            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == RESULT_OK) {
            updatetableforurl();
            Log.e("on activity result", "");
            new Encode_image().execute();
        }
    }



    private void updatetableforurl() {

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {



//                System.out.println("*** doInBackground ** paramUsername " + paramUsername + " paramPassword :" + paramPassword);

                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://plant123456.000webhostapp.com/userplant_server.php");
                BasicNameValuePair usernameBasicNameValuePair = new BasicNameValuePair("userid", FragmentOtpCall.username);
                BasicNameValuePair passwordBasicNameValuePAir = new BasicNameValuePair("pid", "1");
                BasicNameValuePair regBasicNameValuePAir = new BasicNameValuePair("reg_user", "1");
                BasicNameValuePair fileBasicNameValuePAir = new BasicNameValuePair("filename", image_name);
                List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
                nameValuePairList.add(usernameBasicNameValuePair);
                nameValuePairList.add(passwordBasicNameValuePAir);
                nameValuePairList.add(regBasicNameValuePAir);
                nameValuePairList.add(fileBasicNameValuePAir);

                try {
                    // UrlEncodedFormEntity is an entity composed of a list of url-encoded pairs.
                    //This is typically useful while sending an HTTP POST request.
                    UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairList);

                    // setEntity() hands the entity (here it is urlEncodedFormEntity) to the request.
                    httpPost.setEntity(urlEncodedFormEntity);
 it is to being a product, how creative your solution is and how convincing your pitch presentation is.
                    try {
                        // HttpResponse is an interface just like HttpPost.
                        //Therefore we can't initialize them
                        HttpResponse httpResponse = httpClient.execute(httpPost);

                        // According to the JAVA API, InputStream constructor do nothing.
                        //So we can't initialize InputStream although it is not an interface
                        InputStream inputStream = httpResponse.getEntity().getContent();

                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                        StringBuilder stringBuilder = new StringBuilder();

                        String bufferedStrChunk = null;

                        while ((bufferedStrChunk = bufferedReader.readLine()) != null) {
                            stringBuilder.append(bufferedStrChunk);
                        }

                        return stringBuilder.toString();

                    } catch (ClientProtocolException cpe) {
                        System.out.println("First Exception caz of HttpResponese :" + cpe);
                        cpe.printStackTrace();
                    } catch (IOException ioe) {
                        System.out.println("Second Exception caz of HttpResponse :" + ioe);
                        ioe.printStackTrace();
                    }

                } catch (UnsupportedEncodingException uee) {
                    System.out.println("An Exception given because of UrlEncodedFormEntity argument :" + uee);
                    uee.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                Log.e("result",""+result);
                if(result.contains("Record updated successfully")) {
                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Please wait while it uploads in background",Toast.LENGTH_SHORT).show();
                }
            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute();
    }

    public static class Encode_image extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {

            bitmap = BitmapFactory.decodeFile(file_uri.getPath());
            Log.e("file url path", file_uri.getPath());
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            bitmap.recycle();

            byte[] array = stream.toByteArray();
            encoded_string = Base64.encodeToString(array, 0);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            makeRequest();
        }
    }


    private static void makeRequest() {
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {

                Log.e("request made", "photo");
                RequestQueue requestQueue = Volley.newRequestQueue(mctx);
                StringRequest request = new StringRequest(Request.Method.POST, "http://plant123456.000webhostapp.com/image_upload.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.e("upload status", response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("upload error", "" + error);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> map = new HashMap<>();
                        map.put("encoded_string", encoded_string);
                        map.put("image_name", image_name);
                        Log.e("enocoded", "" + encoded_string);
                        return map;
                    }
                };
                requestQueue.add(request);

                return null;
            }

            @Override
            protected void onPostExecute(String result) {

                super.onPostExecute(result);

            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute();
    }


    public void sendInvites() {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    public void drawerContral() {

        if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
            mDrawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            mDrawerLayout.openDrawer(Gravity.LEFT);
        }
    }


}
