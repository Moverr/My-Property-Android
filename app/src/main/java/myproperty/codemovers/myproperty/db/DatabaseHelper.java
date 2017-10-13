package myproperty.codemovers.myproperty.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mover on 10/12/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    //SQLiteOpenHelper
    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "myProperty";

    // Table Names
    private static final String TABLE_ACCOUNTS = "accounts";
    private static final String TABLE_ACCOUNT_TYPES = "account_types";
    private static final String TABLE_ADDRESS = "address";
    private static final String TABLE_CONTACTS = "contacts";
    private static final String TABLE_PACKAGES = "packages";
    private static final String TABLE_PERMISSIONS = "permissions";
    private static final String TABLE_PERMISSION_ROLE = "permission_role";
    private static final String TABLE_PERSON = "person";
    private static final String TABLE_PROPERTY = "property";
    private static final String TABLE_PROPERTY_CLASSIFICATION = "property_classification";
    private static final String TABLE_PROPERTY_SIZE = "property_size";
    private static final String TABLE_PROPERTY_TYPES = "property_types";
    private static final String TABLE_ROLES = "roles";
    private static final String TABLE_USER = "user";
    private static final String TABLE_USER_ROLE = "user_role";






    // NOTES Table - column nmaes
    private static final String KEY_TODO = "todo";
    private static final String KEY_STATUS = "status";

    // TAGS Table - column names
    private static final String KEY_TAG_NAME = "tag_name";

    // NOTE_TAGS Table - column names
    private static final String KEY_TODO_ID = "todo_id";
    private static final String KEY_TAG_ID = "tag_id";

    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_ACCOUNTS = "CREATE TABLE IF NOT EXISTS `accounts` (\n" +
            "  `id` int(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `user_id` int(20) NOT NULL DEFAULT '0',\n" +
            "  `package_id` int(20) NOT NULL DEFAULT '0',\n" +
            "  `account_type_id` int(20) NOT NULL DEFAULT '0',\n" +
            "  `parent_id` int(20) NOT NULL DEFAULT '0',\n" +
            "  `status` enum('ACTIVE','DEACTIVATED','PENDING') NOT NULL DEFAULT 'PENDING',\n" +
            "  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
            "  `created_by` int(20) NOT NULL,\n" +
            "  `date_updated` datetime DEFAULT NULL,\n" +
            "  `updated_by` int(20) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  KEY `AC_USER` (`user_id`),\n" +
            "  KEY `AC_PACKAGE` (`package_id`),\n" +
            "  KEY `AC_ACCOUNT_TYPE` (`account_type_id`),\n" +
            "  CONSTRAINT `AC_ACCOUNT_TYPE` FOREIGN KEY (`account_type_id`) REFERENCES `account_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `AC_PACKAGE` FOREIGN KEY (`package_id`) REFERENCES `packages` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `AC_USER` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='Manage System Accounts. this is a fundamental part of the application';\n";

    // Tag table create statement
    private static final String CREATE_TABLE_ACCOUNT_TYPES = "CREATE TABLE IF NOT EXISTS `account_types` (\n" +
            "  `id` int(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `account_type` varchar(255) NOT NULL DEFAULT '0',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `account_type` (`account_type`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='Account Types eg Personal, Company, Broker, it helps in classifying accounts : ';\n";

    // todo_tag table create statement
    private static final String CREATE_TABLE_ADDRESS = "CREATE TABLE IF NOT EXISTS `address` (\n" +
            "  `id` int(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `location` varchar(255) NOT NULL DEFAULT '0',\n" +
            "  `lat` varchar(255) NOT NULL DEFAULT '0',\n" +
            "  `lng` varchar(255) NOT NULL DEFAULT '0',\n" +
            "  `createdby` int(20) NOT NULL DEFAULT '0',\n" +
            "  `datecreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
            "  `updatedby` int(20) DEFAULT NULL,\n" +
            "  `dateupdated` datetime DEFAULT NULL,\n" +
            "  `status` enum('ACTIVE','ARCHIVED') NOT NULL DEFAULT 'ACTIVE',\n" +
            "  `parent_type` varchar(255) DEFAULT NULL,\n" +
            "  `parent_id` int(20) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  KEY `CreatedBy` (`createdby`),\n" +
            "  KEY `UpdatedBy` (`updatedby`),\n" +
            "  FULLTEXT KEY `location` (`location`),\n" +
            "  CONSTRAINT `CreatedBy` FOREIGN KEY (`createdby`) REFERENCES `user` (`id`),\n" +
            "  CONSTRAINT `UpdatedBy` FOREIGN KEY (`updatedby`) REFERENCES `user` (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='Manage All Addresses in the System';\n";



    // Tag table create statement
    private static final String CREATE_TABLE_ACCOUNT_ACCOUNTS = "CREATE TABLE IF NOT EXISTS `contacts` (\n" +
            "  `id` int(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `type` varchar(255) NOT NULL,\n" +
            "  `details` varchar(255) NOT NULL,\n" +
            "  `created_by` int(20) NOT NULL,\n" +
            "  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
            "  `updated_by` int(20) DEFAULT NULL,\n" +
            "  `date_updated` datetime DEFAULT NULL,\n" +
            "  `status` enum('ACTIVE','ARCHIVED') NOT NULL DEFAULT 'ACTIVE',\n" +
            "  `parent_type` varchar(255) NOT NULL,\n" +
            "  `parent_id` int(20) NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  KEY `CC_CreatedBy` (`created_by`),\n" +
            "  KEY `CC_UpdatedBy` (`updated_by`),\n" +
            "  CONSTRAINT `CC_CreatedBy` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`),\n" +
            "  CONSTRAINT `CC_UpdatedBy` FOREIGN KEY (`updated_by`) REFERENCES `user` (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='Manage System Level Contacts \\r\\nWebsites, Phone,Fax,Social Media, Etc';\n";

    private static final String CREATE_TABLE_ACCOUNT_PACKAGES= "CREATE TABLE IF NOT EXISTS `packages` (\n" +
            "  `id` int(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `package` varchar(255) NOT NULL DEFAULT '0',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `package` (`package`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='Manage App Packages';\n";

    private static final String CREATE_TABLE_ACCOUNT_PERMISSIONS= "CREATE TABLE IF NOT EXISTS `permissions` (\n" +
            "  `id` int(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `name` varchar(100) NOT NULL DEFAULT '0',\n" +
            "  `grouping` varchar(100) NOT NULL DEFAULT '0',\n" +
            "  `code` varchar(50) NOT NULL DEFAULT '0',\n" +
            "  `status` enum('ACTIVE','ARCHIVED') NOT NULL DEFAULT 'ACTIVE',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `name_grouping_code` (`name`,`grouping`,`code`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Manage System Permissions';\n";

    private static final String CREATE_TABLE_ACCOUNT_PERMISSION_ROLE= "CREATE TABLE IF NOT EXISTS `permission_role` (\n" +
            "  `id` int(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `permission_id` int(20) DEFAULT NULL,\n" +
            "  `role_id` int(20) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  KEY `PR_PERMISSION` (`permission_id`),\n" +
            "  KEY `PR_ROLE` (`role_id`),\n" +
            "  CONSTRAINT `PR_PERMISSION` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `PR_ROLE` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Pivot Table to Merge Permission to Role ';\n";

    private static final String CREATE_TABLE_PERSON="CREATE TABLE IF NOT EXISTS `person` (\n" +
            "  `id` int(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `userId` int(20) DEFAULT NULL,\n" +
            "  `names` varchar(500) DEFAULT NULL,\n" +
            "  `gender` enum('MALE','FEMALE','OTHER') DEFAULT NULL,\n" +
            "  `dateofbirth` date DEFAULT NULL,\n" +
            "  `date_created` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
            "  `created_by` int(20) DEFAULT NULL,\n" +
            "  `date_updated` datetime DEFAULT NULL,\n" +
            "  `updated_by` int(20) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  KEY `P_USERID_idx` (`userId`),\n" +
            "  KEY `P_UPDATEDBY_idx` (`updated_by`),\n" +
            "  KEY `P_CREATEDBY_idx` (`created_by`),\n" +
            "  CONSTRAINT `P_CREATEDBY` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `P_UPDATEDBY` FOREIGN KEY (`updated_by`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `P_USERID` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='Manage Profile, Personal  Information ';\n";


    private static final String CREATE_TABLE_PROPERTY="CREATE TABLE IF NOT EXISTS `property` (\n" +
            "  `id` int(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `userId` int(20) NOT NULL DEFAULT '0',\n" +
            "  `dateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
            "  `dateUpdated` datetime DEFAULT NULL,\n" +
            "  `type` int(20) DEFAULT NULL,\n" +
            "  `brief` varchar(75) NOT NULL DEFAULT '0',\n" +
            "  `accountId` int(20) NOT NULL DEFAULT '0',\n" +
            "  `status` enum('ACTIVE','ARCHIVED','PENDING') NOT NULL DEFAULT 'PENDING',\n" +
            "  `details` varchar(500) NOT NULL DEFAULT '0',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  KEY `PUSER` (`userId`),\n" +
            "  KEY `PACCOUNT` (`accountId`),\n" +
            "  KEY `PTYPE` (`type`),\n" +
            "  CONSTRAINT `PACCOUNT` FOREIGN KEY (`accountId`) REFERENCES `accounts` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `PTYPE` FOREIGN KEY (`type`) REFERENCES `property_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `PUSER` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;\n";


    private static final String CREATE_TABLE_PROPERTY_CLASSIFICATION="CREATE TABLE IF NOT EXISTS `property_classification` (\n" +
            "  `id` int(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `classification` varchar(255) NOT NULL DEFAULT '0',\n" +
            "  `abbrev` varchar(50) NOT NULL DEFAULT '0',\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Commercial , Residential';\n";

    private static final String CREATE_TABLE_PROPERTY_SIZE="CREATE TABLE IF NOT EXISTS `property_size` (\n" +
            "  `id` int(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `property_id` int(20) NOT NULL,\n" +
            "  `size` varchar(255) NOT NULL,\n" +
            "  `unitMeasure` enum('METRE','FEET','ACRE','KILOMETRE','MILE') NOT NULL DEFAULT 'METRE',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  KEY `PS_PROPERTY` (`property_id`),\n" +
            "  CONSTRAINT `PS_PROPERTY` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='Property Size';\n";


    private static final String CREATE_TABLE_PROPERTY_TYPES="CREATE TABLE IF NOT EXISTS `property_types` (\n" +
            "  `id` int(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `classification_id` int(20) NOT NULL DEFAULT '0',\n" +
            "  `type` varchar(255) NOT NULL DEFAULT '0',\n" +
            "  `status` enum('ACTIVE','ARCHIVED') NOT NULL DEFAULT 'ACTIVE',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  KEY `pt_classification_id` (`classification_id`),\n" +
            "  CONSTRAINT `pt_classification_id` FOREIGN KEY (`classification_id`) REFERENCES `property_classification` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Property Types Under Classification';\n";


    private static final String CREATE_TABLE_ROLES="CREATE TABLE IF NOT EXISTS `roles` (\n" +
            "  `id` int(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `name` varchar(100) DEFAULT '0',\n" +
            "  `code` varchar(50) DEFAULT '0',\n" +
            "  `brief` varchar(255) DEFAULT '0',\n" +
            "  `status` enum('ACTIVE','ARCHIVED') DEFAULT 'ACTIVE',\n" +
            "  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
            "  `created_by` int(20) DEFAULT NULL,\n" +
            "  `date_updated` datetime DEFAULT NULL,\n" +
            "  `updated_by` int(20) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `code` (`code`),\n" +
            "  UNIQUE KEY `Composite_Name_and_status_Unique` (`name`,`status`),\n" +
            "  KEY `RL_CreatedBy` (`created_by`),\n" +
            "  KEY `RL_UpdatedBy` (`updated_by`),\n" +
            "  CONSTRAINT `RL_CreatedBy` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `RL_UpdatedBy` FOREIGN KEY (`updated_by`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Manage User Roles in the System';\n";


    private static final String CREATE_TABLE_USER="CREATE TABLE IF NOT EXISTS `user` (\n" +
            "  `id` int(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `username` varchar(255) NOT NULL DEFAULT '0',\n" +
            "  `password` varchar(255) NOT NULL DEFAULT '0',\n" +
            "  `status` enum('ACTIVE','PENDING','DEACTIVATED') NOT NULL DEFAULT 'PENDING',\n" +
            "  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='Manage User Login, Active, Deactive user,  Password Update, ';\n";

    private static final String CREATE_TABLE_USER_ROLE="CREATE TABLE IF NOT EXISTS `user_role` (\n" +
            "  `id` int(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `user_id` int(20) NOT NULL DEFAULT '0',\n" +
            "  `status` enum('ACTIVE','ARCHIVED') NOT NULL DEFAULT 'ACTIVE',\n" +
            "  `role_id` int(20) NOT NULL DEFAULT '0',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  KEY `US_USER` (`user_id`),\n" +
            "  KEY `US_ROLE` (`role_id`),\n" +
            "  CONSTRAINT `US_ROLE` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `US_USER` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='Pivot Table to Merge User and Role ';\n";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_TODO);
        db.execSQL(CREATE_TABLE_TAG);
        db.execSQL(CREATE_TABLE_TODO_TAG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TAG);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO_TAG);

        // create new tables
        onCreate(db);
    }
}