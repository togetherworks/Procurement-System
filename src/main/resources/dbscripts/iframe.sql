--DROP TABLE TBL_CODE_INT;
--DROP TABLE TBL_CODETYPE;
--DROP TABLE TBL_MENU_REPOSITORY;
--DROP TABLE TBL_MENU_ITEM;


CREATE TABLE TBL_CODETYPE (
    CODETYPE_ID                    VARCHAR(20)      NOT NULL,
    CODETYPE_DESC                  VARCHAR(66),
    CODETYPE_TABLE                 VARCHAR(66),
    READ_ONLY                      CHAR(1),
    COL_CODETYPE_ID                VARCHAR(66),
    COL_CODE_ID                    VARCHAR(66),
    COL_CODE_DESC                  VARCHAR(66),
    COL_CODE_SEQ                   VARCHAR(66),
    COL_STATUS                     VARCHAR(66),
    COL_EFFECTIVE_DT               VARCHAR(66),
    COL_EXPIRY_DT                  VARCHAR(66),
    EDIT_URL                       VARCHAR(120),
    ADD_URL                        VARCHAR(120),
    OWNER_GROUP                    VARCHAR(200),
    UPDATED_BY                     VARCHAR(32),
    UPDATED_DT                     TIMESTAMP,
    COL_CODE_LOCALE                VARCHAR(20)
);

ALTER TABLE TBL_CODETYPE ADD CONSTRAINT
    PK_TBL_CODETYPE PRIMARY KEY (CODETYPE_ID);

CREATE TABLE TBL_CODE_INT (
    CODETYPE_ID                    VARCHAR(20)      NOT NULL,
    CODE_ID                        VARCHAR(20)      NOT NULL,
    CODE_DESC                      VARCHAR(66),
    CODE_SEQ                       INTEGER,
    STATUS                         CHAR(1)          NOT NULL,
    EFFECTIVE_DT                   TIMESTAMP,
    EXPIRY_DT                      TIMESTAMP,
    UPDATED_BY                     VARCHAR(32),
    UPDATED_DT                     TIMESTAMP,
    LOCALE                         VARCHAR(2)       NOT NULL
);

ALTER TABLE TBL_CODE_INT ADD CONSTRAINT
    PK_TBL_CODE_INT    PRIMARY KEY (CODETYPE_ID, CODE_ID, LOCALE);
ALTER TABLE TBL_CODE_INT ADD CONSTRAINT
    FK_CI_CODETYPE_ID  FOREIGN KEY (CODETYPE_ID) REFERENCES TBL_CODETYPE (CODETYPE_ID);


CREATE TABLE TBL_MENU_ITEM (
    REPOSITORY_ID                  VARCHAR(32)      NOT NULL,
    ITEM_ID                        VARCHAR(32)      NOT NULL,
    PARENT_ITEM_ID                 VARCHAR(32),
    ITEM_SEQ                       INTEGER,
    NAME                           VARCHAR(120)     NOT NULL,
    TITLE                          VARCHAR(120),
    LOCATION                       VARCHAR(120),
    TARGET                         VARCHAR(120),
    DESCRIPTION                    VARCHAR(120),
    ON_CLICK                       VARCHAR(120),
    ON_MOUSE_OVER                  VARCHAR(120),
    ON_MOUSE_OUT                   VARCHAR(120),
    IMAGE                          VARCHAR(120),
    ALT_IMAGE                      VARCHAR(120),
    TOOL_TIP                       VARCHAR(120),
    ROLES                          VARCHAR(120),
    PAGE                           VARCHAR(120),
    CATEGORY                       VARCHAR(120),
    VERSION                        INTEGER
);

ALTER TABLE TBL_MENU_ITEM ADD CONSTRAINT
    PK_TBL_MENU_ITEM   PRIMARY KEY (REPOSITORY_ID, NAME);

CREATE TABLE TBL_MENU_REPOSITORY (
    REPOSITORY_ID                  VARCHAR(32)      NOT NULL,
    REPOSITORY_DESC                VARCHAR(50)
);

ALTER TABLE TBL_MENU_REPOSITORY ADD CONSTRAINT
    PK_MENU_REPOSITORY PRIMARY KEY (REPOSITORY_ID);

insert into tbl_codetype values('acm_res','ACM Resources Type','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/viewedit_int.do',null,'DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('addr_type','Address Type','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/viewedit_int.do',null,'DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('application','Application List','TBL_AA_APP','Y',null,'APP_ID','APP_NAME','APP_NAME',null,null,null,null,null,null,null,null,null);
insert into tbl_codetype values('app_status','Approve Status','TBL_EVENTMGMT_APPSTS','N',null,'STATUS_ID','STATUS_DESC',null,'STATUS',null,null,'/codeadmin/viewedit_venue.do','/codeadmin/add_venue.do',null,null,null,'LOCALE');
insert into tbl_codetype values('auditLevel','Log Audit Level','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/viewedit_int.do',null,'DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('boolean_yn','Yes / No','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/viewedit_int.do',null,'DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('contact','Types Of Contact','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/viewedit_int.do',null,'DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('country','Country','TBL_CODE_COUNTRY','N',null,'COUNTRY_ID','COUNTRY_DESC',null,'STATUS',null,null,'/codeadmin/viewedit_country.do','/codeadmin/add_country.do','DEF-group-groupA',null,null,'COUNTRY_LOCALE');
insert into tbl_codetype values('dateType','time date Type','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/viewedit_int.do',null,'DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('event_type','Event Type','TBL_EVENTMGMT_ETYPE','N',null,'TYPE_ID','TYPE_DESC',null,'STATUS',null,null,'/codeadmin/viewedit_venue.do','/codeadmin/add_venue.do',null,null,null,'LOCALE');
insert into tbl_codetype values('gender','Gender','TBL_CODE_INT','N','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/viewedit_int.do','/codeadmin/add_int.do?codeInt.codeTypeId=gender&codeInt.codeTypeDesc=Gender','DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('industry','Industry','TBL_SAMPLE_INDUSTRY','N',null,'INDUSTRY_ID','INDUSTRY_DESC',null,'STATUS',null,null,'/codeadmin/viewedit_industry.do','/codeadmin/add_industry.do','DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('loginType','loginType','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/viewedit_int.do',null,'DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('martial','Martial Status','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/viewedit_int.do',null,'DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('PageSize','PageSize','TBL_CODE_INT','N','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,null,null,null,null,null,'LOCALE');
insert into tbl_codetype values('process_st','Process Status','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,null,null,null,null,null,'LOCALE');
insert into tbl_codetype values('pubDest','publisher Dest','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,null,null,'DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('pubStatus','publisher Status','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,null,null,'DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('rec_type','Record Type','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/viewedit_int.do',null,'DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('salutation','Salutation','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/viewedit_int.do',null,'DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('schStatus','Schedule status','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,null,null,'DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('simple_status','simple status','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/viewedit_int.do',null,'DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('SLAConditionDate','SLA Condition Date','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,null,null,null,null,null,'LOCALE');
insert into tbl_codetype values('SLAType','Process SLA Type','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,null,null,null,null,null,'LOCALE');
insert into tbl_codetype values('status','Status','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/viewedit_int.do',null,'DEF-group-groupA',null,null,'LOCALE');
insert into tbl_codetype values('survey_st','Survey Status','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/codeadmin/viewedit_int.do',null,null,null,null,'LOCALE');
insert into tbl_codetype values('svy_ans_st','Survey Answer Status','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/codeadmin/viewedit_int.do',null,null,null,null,'LOCALE');
insert into tbl_codetype values('svy_qn_typ','Survey Question Type','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/codeadmin/viewedit_int.do',null,null,null,null,'LOCALE');
insert into tbl_codetype values('svy_typ','Survey Type','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/codeadmin/viewedit_int.do',null,null,null,null,'LOCALE');
insert into tbl_codetype values('task_st','Task Status','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,null,null,null,null,null,'LOCALE');
insert into tbl_codetype values('translogtype','Transaction Type','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/codeadmin/viewedit_int.do',null,null,null,null,'LOCALE');
insert into tbl_codetype values('venue','Venue','TBL_EVENTMGMT_VENUE','N',null,'VENUE_ID','VENUE_DESC',null,'STATUS',null,null,'/codeadmin/viewedit_venue.do','/codeadmin/add_venue.do',null,null,null,'LOCALE');
insert into tbl_codetype values('wregion','World Region','TBL_CODE_INT','Y','CODETYPE_ID','CODE_ID','CODE_DESC','CODE_SEQ',null,null,null,'/codeadmin/viewedit_int.do',null,'DEF-group-groupA',null,null,'LOCALE');

insert into tbl_code_int values('acm_res','DOC_TYPE','Document Type',6,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('acm_res','iPortal','iPortal Page ID',3,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('acm_res','JSP_TAG','Jsp Tag',2,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('acm_res','LOG_NAME','Collection',5,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('acm_res','LOG_ROLE','Logical Roles',4,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('acm_res','SEC_ROLE','Security Roles',7,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('acm_res','URI','URI',1,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('industry','BUILDING','Document Type',6,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('industry','BUILDING SERVICES','Document Type',6,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('industry','CAMERA','Document Type',6,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('industry','CAREER DEVELOPMENT T','Document Type',6,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('industry','COMPUTER SUPPLIES','Document Type',6,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('industry','CORPORATE GIFTS','Document Type',6,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('industry','DISPLAY_SYSTEMS','Document Type',6,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('industry','E-COP.NET SUBSCRIPTI','Document Type',6,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('industry','EQUIPMENT RACKS','Document Type',6,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('industry','HARDWARE','Document Type',6,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('industry','NOTEBOOKS','Document Type',6,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('industry','PRODUCT','Document Type',6,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('industry','WORK','Document Type',6,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('loginType','CONTAINER','Container Login',6,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('loginType','KERBEROS','Kerberos Login',5,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('loginType','LDAP','LDAP Login',7,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('loginType','NETRUST','Netrust Login',4,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('loginType','PASSWORD','Password Login',1,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('loginType','SINGPASS','Singpass Login',2,'A','2011-03-24 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('loginType','SINGPASS_EASY','Singpass With Easy Login',3,'A','2011-02-11 00:00:00','2008-01-01 00:00:00',null,null,'en');
insert into tbl_code_int values('PageSize','10','10 items per page',2,'A',null,null,null,null,'en');
insert into tbl_code_int values('PageSize','15','15 items per page',3,'A',null,null,null,null,'en');
insert into tbl_code_int values('PageSize','5','5 items per Page',1,'A',null,null,null,null,'en');
insert into tbl_code_int values('process_st','A','Active',1,'A',null,null,'DEF-user-useradmin',null,'en');
insert into tbl_code_int values('process_st','C','Completed',2,'A',null,null,'DEF-user-useradmin',null,'en');
insert into tbl_code_int values('process_st','F','Failed',6,'A',null,null,'DEF-user-useradmin',null,'en');
insert into tbl_code_int values('process_st','K','Creating',5,'A',null,null,'DEF-user-useradmin',null,'en');
insert into tbl_code_int values('process_st','S','Suspended',3,'A',null,null,'DEF-user-useradmin',null,'en');
insert into tbl_code_int values('process_st','T','Terminated',4,'A',null,null,'DEF-user-useradmin',null,'en');
insert into tbl_code_int values('pubDest','File','File',2,'A',null,null,null,null,'en');
insert into tbl_code_int values('pubDest','FTP','FTP',1,'A',null,null,null,null,'en');
insert into tbl_code_int values('pubStatus','A','Active',1,'A',null,null,null,null,'en');
insert into tbl_code_int values('pubStatus','I','Inactive',2,'A',null,null,null,null,'en');
insert into tbl_code_int values('schStatus','C','Successful',6,'A',null,null,null,null,'en');
insert into tbl_code_int values('schStatus','F','Failed',4,'A',null,null,null,null,'en');
insert into tbl_code_int values('schStatus','N','Unscheduled',5,'A',null,null,null,null,'en');
insert into tbl_code_int values('schStatus','P','Published',2,'A',null,null,null,null,'en');
insert into tbl_code_int values('schStatus','S','Scheduled',1,'A',null,null,null,null,'en');
insert into tbl_code_int values('schStatus','U','Unpublished',3,'A',null,null,null,null,'en');
insert into tbl_code_int values('SLAConditionDate','Business Day','Business Day',1,'A',null,null,'DEF-user-useradmin',null,'en');
insert into tbl_code_int values('SLAConditionDate','Calendar Day','Calendar Day',2,'A',null,null,'DEF-user-useradmin',null,'en');
insert into tbl_code_int values('SLAType','APN','Active Pins Number',2,'A',null,null,'DEF-user-useradmin',null,'en');
insert into tbl_code_int values('SLAType','CPN','Completed Pins Number',3,'A',null,null,'DEF-user-useradmin',null,'en');
insert into tbl_code_int values('SLAType','RT','Response Time',1,'A',null,null,'DEF-user-useradmin',null,'en');
insert into tbl_code_int values('survey_st','C','Closed',3,'A',null,null,null,null,'en');
insert into tbl_code_int values('survey_st','N','New',1,'A',null,null,null,null,'en');
insert into tbl_code_int values('survey_st','O','Open',2,'A',null,null,null,null,'en');
insert into tbl_code_int values('svy_ans_st','D','Disqualified',3,'A',null,null,null,null,'en');
insert into tbl_code_int values('svy_ans_st','F','Notified',2,'A',null,null,null,null,'en');
insert into tbl_code_int values('svy_ans_st','I','Invalidated',6,'A',null,null,null,null,'en');
insert into tbl_code_int values('svy_ans_st','N','New',1,'A',null,null,null,null,'en');
insert into tbl_code_int values('svy_ans_st','R','Replied',5,'A',null,null,null,null,'en');
insert into tbl_code_int values('svy_ans_st','S','Skipped',7,'A',null,null,null,null,'en');
insert into tbl_code_int values('svy_ans_st','U','Unreachable',4,'A',null,null,null,null,'en');
insert into tbl_code_int values('svy_ans_st','Z','No Response',8,'A',null,null,null,null,'en');
insert into tbl_code_int values('svy_qn_typ','E','Essay',3,'A',null,null,null,null,'en');
insert into tbl_code_int values('svy_qn_typ','L','One-Line Answer',2,'A',null,null,null,null,'en');
insert into tbl_code_int values('svy_qn_typ','M','Multiple Selection',5,'A',null,null,null,null,'en');
insert into tbl_code_int values('svy_qn_typ','S','Single Selection',4,'A',null,null,null,null,'en');
insert into tbl_code_int values('svy_qn_typ','T','Text',1,'A',null,null,null,null,'en');
insert into tbl_code_int values('svy_typ','P','Poll',2,'A',null,null,null,null,'en');
insert into tbl_code_int values('svy_typ','R','Restricted Survey',3,'A',null,null,null,null,'en');
insert into tbl_code_int values('svy_typ','S','Survey',1,'A',null,null,null,null,'en');
insert into tbl_code_int values('task_st','C','Complete Failed',3,'A',null,null,'DEF-user-useradmin',null,'en');
insert into tbl_code_int values('task_st','P','Processing',2,'A',null,null,'DEF-user-useradmin',null,'en');
insert into tbl_code_int values('task_st','S','Skip Failed',3,'A',null,null,'DEF-user-useradmin',null,'en');
insert into tbl_code_int values('task_st','W','Waiting',1,'A',null,null,'DEF-user-useradmin',null,'en');
insert into tbl_code_int values('translogtype','DELETE','DELETE',3,'A',null,null,null,null,'en');
insert into tbl_code_int values('translogtype','INSERT','INSERT',1,'A',null,null,null,null,'en');
insert into tbl_code_int values('translogtype','UPDATE','UPDATE',2,'A',null,null,null,null,'en');

insert into tbl_code_int values ('status','A','Active',1,'A',null,null,null,null,'en');
insert into tbl_code_int values ('status','I','Inactive',3,'A',null,null,null,null,'en');
insert into tbl_code_int values ('status','P','Pending',5,'P',null,null,null,null,'en');
insert into tbl_code_int values ('status','R','Revoked',4,'A',null,null,null,null,'en');
insert into tbl_code_int values ('status','S','Suspended',2,'A',null,null,null,null,'en');