package com.planty.app.ormfiles;


import com.planty.app.App;
import com.planty.app.model.DbSQLiteHelper;
import com.planty.app.supportfiles.CommonMethods;

/**
 * * This class is under work in progress
 * This class contains variables to interact with our database
 */

public class DbSupport {

    final public static int STATUS_SUCCESS = 1, STATUS_FAILURE = 0, STATUS_INCOMLETE = -1;


    public DbSQLiteHelper getDbModel() {
        return CommonMethods.getDbModel(App.getAppContext());
    }


}
