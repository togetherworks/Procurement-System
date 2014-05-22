--DROP TABLE TBL_SAMPLE_INDUSTRY;
--DROP TABLE TBL_SAMPLE_CUSTOMER;

--
---------------------------------------------
-- Creation of TBL_SAMPLE_CUSTOMER
---------------------------------------------
--
CREATE TABLE TBL_SAMPLE_CUSTOMER (
    CUSTOMER_ID                    VARCHAR(32)      NOT NULL,
    NAME                           VARCHAR(100)     NOT NULL,
    TEL_MAIN                       VARCHAR(20),
    INDUSTRY_CD                    VARCHAR(10)      NOT NULL,
    REMARKS                        VARCHAR(200),
    IMAGEPATH					   VARCHAR(50),
    VERSION                        INTEGER          NOT NULL,
    UPDATED_DT                     TIMESTAMP,
    DATA_FILTER_ID                 VARCHAR(32)
);

ALTER TABLE TBL_SAMPLE_CUSTOMER ADD CONSTRAINT
    PK_SAMPLE_CUSTOMER PRIMARY KEY (CUSTOMER_ID);

--
---------------------------------------------
-- Creation of TBL_SAMPLE_INDUSTRY
---------------------------------------------
--
CREATE TABLE TBL_SAMPLE_INDUSTRY (
    INDUSTRY_ID                    VARCHAR(10)      NOT NULL,
    INDUSTRY_DESC                  VARCHAR(66),
    STATUS                         CHAR(1),
    CREATED_BY                     VARCHAR(32),
    CREATED_DT                     TIMESTAMP,
    UPDATED_BY                     VARCHAR(32)      ,
    UPDATED_DT                     TIMESTAMP        ,
    VERSION                        INTEGER,
    LOCALE                         VARCHAR(2)       NOT NULL
);

ALTER TABLE TBL_SAMPLE_INDUSTRY ADD CONSTRAINT
    PK_SAMPLE_INDUSTRY PRIMARY KEY (INDUSTRY_ID, LOCALE);


DELETE FROM TBL_CODE_INT WHERE CODETYPE_ID = 'addr_type' OR
                               CODETYPE_ID = 'boolean_yn' OR
	                           	 CODETYPE_ID = 'contact' OR
                               CODETYPE_ID = 'country' OR
                               CODETYPE_ID = 'gender' OR
                               CODETYPE_ID = 'industry' OR
                               CODETYPE_ID = 'martial' OR
                               CODETYPE_ID = 'rec_type' OR
                               CODETYPE_ID = 'status' OR
                               CODETYPE_ID = 'wregion' OR
                               CODETYPE_ID = 'salutation' OR
                               CODETYPE_ID = 'simple_status' OR
							                 CODETYPE_ID = 'auditLevel' OR
							                 CODETYPE_ID = 'PageSize' OR
                               CODETYPE_ID = 'dateType';

DELETE FROM TBL_CODETYPE WHERE CODETYPE_ID = 'addr_type' OR
                               CODETYPE_ID = 'boolean_yn' OR
	                           CODETYPE_ID = 'contact' OR
                               CODETYPE_ID = 'country' OR
                               CODETYPE_ID = 'gender' OR
                               CODETYPE_ID = 'industry' OR
                               CODETYPE_ID = 'martial' OR
                               CODETYPE_ID = 'rec_type' OR
                               CODETYPE_ID = 'status' OR
                               CODETYPE_ID = 'wregion' OR
                               CODETYPE_ID = 'salutation' OR
                               CODETYPE_ID = 'simple_status' OR
							                 CODETYPE_ID = 'auditLevel' OR
							                 CODETYPE_ID = 'PageSize' OR
                               CODETYPE_ID = 'dateType';


insert into tbl_codetype values('industry','Industry','TBL_SAMPLE_INDUSTRY','N',null,'INDUSTRY_ID','INDUSTRY_DESC',null,'STATUS',null,null,'/codeadmin/viewedit_industry.do','/codeadmin/add_industry.do','DEF-group-groupA',null,null,'LOCALE');

INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'BLDG_SRV', 'BUILDING SERVICES', 'A', '', now(), '', now(), 0 , 'en');
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'CABLING', 'CABLING WORK', 'A', '', now(), '', now(), 0 , 'en');
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'CAMERA', 'CAMERA', 'A', '', now(), '', now(), 0, 'en' );
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'CAREER_DEV', 'CAREER DEVELOPMENT TOOLKIT', 'A', '', now(), '', now(), 0, 'en' );
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'COMP_HW', 'COMPUTER HARDWARE', 'A', '', now(), '', now(), 0, 'en');
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'COMP_NB', 'COMPUTER NOTEBOOKS', 'A', '', now(), '', now(), 0, 'en' );
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'COMP_SUP', 'COMPUTER SUPPLIES', 'A', '', now(), '', now(), 0, 'en');
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'COR_GIFTS', 'CORPORATE GIFTS', 'A', '', now(), '', now(), 0, 'en' );
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'DISP_SYS', 'DISPLAY_SYSTEMS', 'A', '', now(), '', now(), 0, 'en' );
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'ECOP_SUB', 'E-COP.NET SUBSCRIPTION', 'A', '', now(), '', now(), 0, 'en' );
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'EQ_RACKS', 'EQUIPMENT RACKS', 'A', '', now(), '', now(), 0, 'en' );
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'GARTNER', 'GARTNER PRODUCT', 'A', '', now(), '', now(), 0, 'en' );
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'NW_DATACOM', 'NETWORKING \& DATACOMMUNICATION', 'A', '', now(), '', now(), 0, 'en' );
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'NW_TRG', 'NETWORK TRAINING COURSE', 'A', '', now(), '', now(), 0, 'en' );
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'OFF_BEVER', 'OFFICE BEVERAGES', 'A', '', now(), '', now(), 0, 'en' );
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'OFF_FURN', 'OFFICE FURNITURES', 'A', '', now(), '', now(), 0, 'en' );
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'PRINT_FILE', 'PRINTING OF FILES', 'A', '', now(), '', now(), 0, 'en' );
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'SANITARY', 'SANITARY WARES', 'A', '', now(), '', now(), 0, 'en' );
INSERT INTO TBL_SAMPLE_INDUSTRY VALUES( 'TT_LABEL', 'THERMAL TRANSFER LABELS', 'A', '', now(), '', now(), 0, 'en' );


INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33c8de53daba24dd00328fb567f2ee9f', '01 COMPUTER SYSTEM', '68720101', 'COMP_SUP', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33c96408daba24dd00328fb5cb7a408d', '2C HOLDING (S) PTE LTD', '63377123', 'COMP_NB', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33c7324adaba24dd00328fb5037e569d', 'ACA Pacific Technology', '65361728', 'CAREER_DEV', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33cc7ddfdaba24dd00328fb534cb3f43', 'ADVANTECH PERIPHERALS SINGAPORE PTE LTD', '62820555', 'COMP_HW', '', '',0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33cce3d0daba24dd00328fb554f0d4b4', 'APPLIED DIGITAL SYSTEM PTE LTD', '67770100', 'COMP_HW', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33cd381ddaba24dd00328fb5bcd0163f', 'AUTOSCAN TECHNOLOGY PTE LTD', '62943338', 'TT_LABEL', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33cd8e23daba24dd00328fb592bf9b83', 'BENEL SINGAPORE PTE LTD', '64833433', 'OFF_FURN', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33cdd003daba24dd00328fb57f4b01b9', 'CABLE CARE PTE LTD', '64837288', 'CABLING', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '830146b1c0a8aa6f004ef6f137636717', 'COURTS SINGAPORE', '67364853', 'OFF_FURN', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33ce336adaba24dd00328fb534fe75df', 'DANFOSS INDUSTRIES PTE LTD', '62614088', 'BLDG_SRV', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33ce791fdaba24dd00328fb521e3d62c', 'DCS SOLUTIONS LTD', '62827655', 'COMP_HW', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33cebbd2daba24dd00328fb539753d70', 'DISPLAY EXPRESS PTE LTD', '67464711', 'DISP_SYS', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33cf0477daba24dd00328fb550776761', 'E-COP.NET (S) PTE LTD', '67882882', 'ECOP_SUB', '', '',0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33c7f8a9daba24dd00328fb50e21120f', 'F\&N COCA-COLA', '68617600', 'OFF_BEVER', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33c9bc99daba24dd00328fb5eada05e3', 'FDS NETWORKS PTE LTD', '63922363', 'NW_DATACOM', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33c9fe29daba24dd00328fb500f53222', 'FILECO PLASTIC INDUSTRIES PTE LTD', '64598268', 'PRINT_FILE', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33ca3913daba24dd00328fb57b3d55fa', 'FOTO GUIDE', '63381438', 'CAMERA', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33ca8cfcdaba24dd00328fb5c17f5934', 'FULLSUN MARKETING PTE LTD', '62950966', 'SANITARY', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33cadee6daba24dd00328fb5ab0b0a0b', 'GARTNER GROUP ADVISORY (SINGAPORE) PTE LTD', '63336773', 'GARTNER', '', '',0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33cb2654daba24dd00328fb57e5681b7', 'GEMIS MARKETING', '62982337', 'COR_GIFTS', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33cbb9a6daba24dd00328fb558d1498d', 'GIFT MEDIA', '62922148', 'COR_GIFTS', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33cc0594daba24dd00328fb52c20a1fd', 'GLOBAL KNOWLEDGE NETWORK (S) PTE LTD', '63322330', 'NW_TRG', '','', 0, now() ,null);
INSERT INTO TBL_SAMPLE_CUSTOMER VALUES( '33c85e5edaba24dd00328fb5885417fb', 'RACK SYSTEMS (SEA)', '67466900', 'EQ_RACKS', '','', 0, now() ,null);


delete from tbl_menu_item where REPOSITORY_ID='SAMPLE-MENU' and NAME in('Customer Sample','File Upload','File Upload Demo','Maintain  Customer');
insert into tbl_menu_item values('SAMPLE-MENU','1',null,1,'Customer Sample','title.customerdirectory',null,null,'Customer Directory',null,null,null,null,null,null,null,null,null,1);
insert into tbl_menu_item values('SAMPLE-MENU','4','3',1,'File Upload','title.demoFileUpload','../upload-sample/registerUser.faces','imain','File Upload',null,null,null,null,null,null,null,null,null,1);
insert into tbl_menu_item values('SAMPLE-MENU','3',null,2,'File Upload Demo','title.demonstration',null,null,'Demonstration',null,null,null,null,null,null,null,null,null,1);
insert into tbl_menu_item values('SAMPLE-MENU','2','1',1,'Maintain  Customer','title.maintainCustomer','../customer/list.faces','imain','Maintain Customer',null,null,null,null,null,null,null,null,null,1);

delete FROM tbl_aa_group2res where group_id='REQ-group-universal' and resources_id='DEF-res-sample-addCust';
delete FROM tbl_aa_resources where resources_id='DEF-res-sample-addCust';
insert into tbl_aa_resources values('DEF-res-sample-addCust','IConnect','Sample - Add Customer','/xhtml/customer/add','URI','PASSWORD','REQ-group-universal',0,0,null,null,now(),'SYSTEM',now(),'SYSTEM',0);
insert into tbl_aa_group2res values('REQ-group-universal','DEF-res-sample-addCust','NA','1','1','1','1',null,null,now(),'SYSTEM',now(),'SYSTEM',1,'REQ-group-universal');
