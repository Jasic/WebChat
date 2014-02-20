-- Pragma foreign_keys=false;
BEGIN TRANSACTION;

IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'CaiPing')
  DROP TABLE [CaiPing];
CREATE TABLE CaiPing (
    PID           INT
  , CaiPingID     VARCHAR(255)
  , CaiPingName   VARCHAR(255)
  , CaiPingName2  VARCHAR(255)
  , CaiPingName3  VARCHAR(255)
  , JiaGe         NUMERIC(19, 10)
  , MoRenDanWei   VARCHAR(255)
  , MoRenDanWei2  VARCHAR(255)
  , MoRenDanWei3  VARCHAR(255)
  , ShowOrder     INT
  , YinCan        TINYINT
  , JianJie       VARCHAR(255)
  , JianJie2      VARCHAR(255)
  , JianJie3      VARCHAR(255)
  , XiaoLei       VARCHAR(255)
  , YinCanInPad   TINYINT
  , FuZhuID       VARCHAR(255)
  , PingYing      VARCHAR(255)
  , BuJiChengTYZF TINYINT
  , BuJiChengDLZF TINYINT
  , BuJiChengXLZF TINYINT
  , NoShowZuoFa   TINYINT
  , ShiJia        TINYINT
  , CanModName    TINYINT
);

-- 2菜品大类
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'CaiPingDaiLei')
  DROP TABLE [CaiPingDaiLei];
CREATE TABLE CaiPingDaiLei (
    PID                INT
  , CaiPingDaiLeiID    VARCHAR(255)
  , CaiPingDaiLeiName  VARCHAR(255)
  , CaiPingDaiLeiName2 VARCHAR(255)
  , CaiPingDaiLeiName3 VARCHAR(255)
  , ShowOrder          INT
  , Hide               TINYINT
  , HideInPad          TINYINT
  , BuJiChengTYZF      TINYINT
  , NoShowZuoFa        TINYINT
);

---  3菜品小类
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'CaiPingXiaoLei')
  DROP TABLE [CaiPingXiaoLei];
CREATE TABLE CaiPingXiaoLei (
    PID                 INT
  , CaiPingXiaoLeiID    VARCHAR(255)
  , CaiPingXiaoLeiName  VARCHAR(255)
  , CaiPingXiaoLeiName2 VARCHAR(255)
  , CaiPingXiaoLeiName3 VARCHAR(255)
  , ShowOrder           INT
  , Hide                TINYINT
  , DaiLei              VARCHAR(255)
  , HideInPad           TINYINT
  , BuJiChengTYZF       TINYINT
  , BuJiChengDLZF       TINYINT
  , NoShowZuoFa         TINYINT
);
---4、菜品做法
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'CaiPingZuoFa')
  DROP TABLE [CaiPingZuoFa];
CREATE TABLE CaiPingZuoFa (
    PID                  INT
  , CaiPingZuoFaID       VARCHAR(255)
  , CaiPingZuoFaName     VARCHAR(255)
  , CaiPingZuoFaName2    VARCHAR(255)
  , CaiPingZuoFaName3    VARCHAR(255)
  , LeiBie               VARCHAR(255)
  , CaiDaLei             VARCHAR(255)
  , CaiLei               VARCHAR(255)
  , CaiP                 VARCHAR(255)
  , PingYing             VARCHAR(255)
  , JiaGe                NUMERIC(19, 10)
  , ChengBenJiaGe        NUMERIC(19, 10)
  , ShiFuoChenYuShuLiang TINYINT
  , MulSelfAmount        TINYINT
);
-- 5、
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'CPDanWeiJiaGe')
  DROP TABLE [CPDanWeiJiaGe];
CREATE TABLE CPDanWeiJiaGe (
    PID             INT
  , ID              VARCHAR(255)
  , DanWeiMing      VARCHAR(255)
  , BiLv            NUMERIC(19, 10)
  , JiaGe           NUMERIC(19, 10)
  , ChengBenJiaGe   NUMERIC(19, 10)
  , XiaoShouTiCheng NUMERIC(19, 10)
  , NoBilling       TINYINT
  , Def             TINYINT
  , DanWeiMing2     VARCHAR(255)
  , DanWeiMing3     VARCHAR(255)
  , CaiP            VARCHAR(255)
);


--- 6、
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'MN_CaiAndSubCai')
  DROP TABLE [MN_CaiAndSubCai];
CREATE TABLE MN_CaiAndSubCai (
    PID       INT
  , ID        VARCHAR(255)
  , Name      VARCHAR(255)
  , MainCai   VARCHAR(255)
  , SubCai    VARCHAR(255)
  , Unit      VARCHAR(255)
  , Amount    INT
  , MaxAmount INT
  , Price     NUMERIC(19, 10)
);


---7 菜品
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'MN_CaiPinAndMember')
  DROP TABLE [MN_CaiPinAndMember];
CREATE TABLE MN_CaiPinAndMember (
    PID        INT
  , ID         VARCHAR(255)
  , Name       VARCHAR(255)
  , Cai        VARCHAR(255)
  , MemberType VARCHAR(255)
  , Price      NUMERIC(19, 10)
  , Unit       VARCHAR(255)
);


-- 8\
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'QuanJuCanShu')
  DROP TABLE [QuanJuCanShu];
CREATE TABLE QuanJuCanShu (
    PID       INT
  , ID        VARCHAR(255)
  , Name      VARCHAR(255)
  , StrVal    VARCHAR(255)
  , StrVal2   VARCHAR(255)
  , StrVal3   VARCHAR(255)
  , IntVal    INT
  , BoolVal   TINYINT
  , DoubleVal NUMERIC(19, 10)
  , DateVal   DATETIME
);
--9
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'TuiCaiYanYing')
  DROP TABLE [TuiCaiYanYing];
CREATE TABLE TuiCaiYanYing (
    PID                INT
  , TuiCaiYanYingID    VARCHAR(255)
  , TuiCaiYanYingName  VARCHAR(255)
  , TuiCaiYanYingName2 VARCHAR(255)
  , TuiCaiYanYingName3 VARCHAR(255)
);

--- 10
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'WL_Appraise')
  DROP TABLE [WL_Appraise];

CREATE TABLE WL_Appraise (
    PID   INT
  , ID    VARCHAR(255)
  , Name  VARCHAR(255)
  , Name2 VARCHAR(255)
  , Name3 VARCHAR(255)
);


--11
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'WL_AppraiseItem')
  DROP TABLE [WL_AppraiseItem];
CREATE TABLE WL_AppraiseItem (
    PID      INT
  , ID       VARCHAR(255)
  , Name     VARCHAR(255)
  , Name2    VARCHAR(255)
  , Name3    VARCHAR(255)
  , Appraise VARCHAR(255)
);

--12
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'WL_Food')
  DROP TABLE [WL_Food];
CREATE TABLE WL_Food (
    PID       INT
  , ID        VARCHAR(255)
  , Name      VARCHAR(255)
  , Hide      TINYINT
  , ShowOrder INT
  , FoodPage  VARCHAR(255)
  , CaiP      VARCHAR(255)
);

---13 Drop Table [WL_FoodPage];
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'WL_FoodPage')
  DROP TABLE [WL_FoodPage];
CREATE TABLE WL_FoodPage (
    PID       INT
  , ID        VARCHAR(255)
  , Name      VARCHAR(255)
  , Hide      TINYINT
  , ShowOrder INT
  , FoodType  VARCHAR(255)
  , PageType  VARCHAR(255)
);
--14
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'WL_FoodSuperType')
  DROP TABLE [WL_FoodSuperType];
CREATE TABLE WL_FoodSuperType (
    PID       INT
  , ID        VARCHAR(255)
  , Name      VARCHAR(255)
  , Name2     VARCHAR(255)
  , Name3     VARCHAR(255)
  , Hide      TINYINT
  , ShowOrder INT
);

--- 15

--  Drop Table [WL_FoodType];
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'WL_FoodType')
  DROP TABLE [WL_FoodType];
CREATE TABLE WL_FoodType (
    PID           INT
  , ID            VARCHAR(255)
  , Name          VARCHAR(255)
  , Name2         VARCHAR(255)
  , Name3         VARCHAR(255)
  , Hide          TINYINT
  , ShowOrder     INT
  , FoodSuperType VARCHAR(255)
);

--16
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'WL_StrResource')
  DROP TABLE [WL_StrResource];
CREATE TABLE WL_StrResource (
    PID    INT
  , ID     VARCHAR(255)
  , Type   VARCHAR(255)
  , StrKey VARCHAR(255)
  , Lan1   VARCHAR(255)
  , Lan2   VARCHAR(255)
  , Lan3   VARCHAR(255)
  , Remark VARCHAR(255)
);

--17
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'XiTongYongHu')
  DROP TABLE [XiTongYongHu];
CREATE TABLE XiTongYongHu (
    PID       INT
  , StaffID   VARCHAR(255)
  , StaffName VARCHAR(255)
);

--18
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'ZuoFaLeiBie')
  DROP TABLE [ZuoFaLeiBie];
CREATE TABLE ZuoFaLeiBie (
    PID  INT
  , ID   VARCHAR(255)
  , Name VARCHAR(255)
);

--19
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'ZuoTai')
  DROP TABLE [ZuoTai];
CREATE TABLE ZuoTai (
    PID         INT
  , ZuoTaiID    VARCHAR(255)
  , ZuoTaiName  VARCHAR(255)
  , ZuoTaiName2 VARCHAR(255)
  , ZuoTaiName3 VARCHAR(255)
  , TaiQu       VARCHAR(255)
);
--- 20
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'ZuoTaiQuYu')
  DROP TABLE [ZuoTaiQuYu];
CREATE TABLE ZuoTaiQuYu (
    PID             INT
  , ZuoTaiQuYuID    VARCHAR(255)
  , ZuoTaiQuYuName  VARCHAR(255)
  , ZuoTaiQuYuName2 VARCHAR(255)
  , ZuoTaiQuYuName3 VARCHAR(255)
  , ShowOrder       INT
);


---------------------------------------- 新增 ---------------------------------
-- 17.客户类型（ClientType）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'ClientType')
  DROP TABLE [ClientType];

--删除表：
--.10.	推送消息记录（PushMessageRecord）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'PushMessageRecord')
  DROP TABLE [PushMessageRecord];

-- 9.	推送的模板消息（TemplateMessage）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'TemplateMessage')
  DROP TABLE [TemplateMessage];

--.8.	预订食物信息（BookFoodInfo）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'BookFoodInfo')
  DROP TABLE [BookFoodInfo];

--7.	订单信息（BillInfo）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'BillInfo')
  DROP TABLE [BillInfo];

--6.	注册用户信息（ClientInfo）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'ClientInfo')
  DROP TABLE [ClientInfo];

--5.	粉丝信息(FansInfo)
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'FansInfo')
  DROP TABLE [FansInfo];

--4	微信服务号（订阅号）信息（ServiceInfo）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'ServiceInfo')
  DROP TABLE [ServiceInfo];

--3、后台管理用户信息表（DaemonAdminInfo）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'DaemonAdminInfo')
  DROP TABLE [DaemonAdminInfo];

--2、餐厅信息表（RestaurantInfo）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'RestaurantInfo')
  DROP TABLE [RestaurantInfo];

--1、餐厅集团信息（RestaurantGroup）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'RestaurantGroup')
  DROP TABLE [RestaurantGroup];


--1、餐厅集团信息（RestaurantGroup）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'RestaurantGroup')
  DROP TABLE [RestaurantGroup];
CREATE TABLE RestaurantGroup (
    PID       INT IDENTITY (1, 1) PRIMARY KEY
  , GroupName VARCHAR(255) NOT NULL UNIQUE
);

--2、餐厅信息表（RestaurantInfo）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'RestaurantInfo')
  DROP TABLE [RestaurantInfo];
-- 分店GroupID、Name、Address复合键唯一
CREATE TABLE RestaurantInfo (
    PID      INT IDENTITY (1, 1) PRIMARY KEY
  , GroupID  INT          NOT NULL
  , ShopID   VARCHAR(64)  NOT NULL UNIQUE
  , Name     VARCHAR(255) NOT NULL
  , Address  VARCHAR(255) NOT NULL
  , Phone    VARCHAR(32)
  , Position VARCHAR(255)
);
ALTER TABLE RestaurantInfo ADD CONSTRAINT RSG_K FOREIGN KEY (GroupID) REFERENCES RestaurantGroup (PID)
ALTER TABLE RestaurantInfo ADD CONSTRAINT GNA_U UNIQUE (GroupID, Name, Address)


--3、后台管理用户信息表（DaemonAdminInfo）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'DaemonAdminInfo')
  DROP TABLE [DaemonAdminInfo];
CREATE TABLE DaemonAdminInfo (
    PID       INT IDENTITY (1, 1) PRIMARY KEY
  , RestID    INT FOREIGN KEY REFERENCES RestaurantInfo (PID)
  , StaffName VARCHAR(255) NOT NULL UNIQUE
  , Passwd    VARCHAR(255) NOT NULL
);

--4	微信服务号（订阅号）信息（ServiceInfo）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'ServiceInfo')
  DROP TABLE [ServiceInfo];
CREATE TABLE ServiceInfo (
    PID       INT IDENTITY (1, 1) PRIMARY KEY
  , RestID    INT
  , WebChatID VARCHAR(64)  NOT NULL UNIQUE
  , URL       VARCHAR(255) NOT NULL
  , Token     VARCHAR(255) NOT NULL
  , BoundDate DATETIME DEFAULT GETDATE()
  , Status    VARCHAR(10)  NOT NULL
);

--5.	粉丝信息(FansInfo)
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'FansInfo')
  DROP TABLE [FansInfo];
CREATE TABLE FansInfo (
    PID           INT IDENTITY (1, 1) PRIMARY KEY
  , WebChatID     VARCHAR(64) NOT NULL UNIQUE
  , ServiceInfoID INT         NOT NULL  FOREIGN KEY REFERENCES ServiceInfo (PID)
  , FanName       VARCHAR(64)
  , Address       VARCHAR(255)
  , Sex           VARCHAR(10)
  , FocusTime     DATETIME DEFAULT GETDATE()
  , FocusType     INT DEFAULT 1
);

--6.	注册用户信息（ClientInfo）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'ClientInfo')
  DROP TABLE [ClientInfo];
CREATE TABLE ClientInfo (
    PID          INT IDENTITY (1, 1) PRIMARY KEY
  , MemberNO     VARCHAR(64) NOT NULL UNIQUE
  , FanInfoId    INT         NOT NULL FOREIGN KEY REFERENCES FansInfo (PID)
  , Email        VARCHAR(64)
  , ClientName   VARCHAR(64)
  , Password     VARCHAR(64) NOT NULL
  , Address      VARCHAR(128)
  , ClientTypeId INT
);


--7.	订单信息（BillInfo）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'BillInfo')
  DROP TABLE [BillInfo];
CREATE TABLE BillInfo (
    PID           INT IDENTITY (1, 1) PRIMARY KEY
  , BilllID       VARCHAR(255) UNIQUE NOT NULL
  , BillStatus    INT                 NOT NULL
  , BillType      INT                 NOT NULL
  , ClientInfoID  INT FOREIGN KEY REFERENCES ClientInfo (PID)
  , ConsumeTime   DATETIME            NOT NULL
  , RoomID        INT DEFAULT -1
  , CustomerCount INT DEFAULT 1
  , CreateTime    DATETIME            NOT NULL DEFAULT GETDATE()
  , FinishTime    DATETIME
  , TotalCost     DECIMAL             NOT NULL
  , Discount      DECIMAL             NOT NULL DEFAULT 1.0
  , ActualPrice   DECIMAL
);

--.8.	预订食物信息（BookFoodInfo）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'BookFoodInfo')
  DROP TABLE [BookFoodInfo];
CREATE TABLE BookFoodInfo (
    PID         INT IDENTITY (1, 1) PRIMARY KEY
  , BillInfoID  INT NOT NULL FOREIGN KEY REFERENCES BillInfo (PID)
  , FoodID      INT NOT NULL
  , FoodCount   INT NOT NULL
  , FoodSuggest VARCHAR(255)
);

--.9.	推送的模板消息（TemplatedMessage）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'TemplateMessage')
  DROP TABLE [TemplateMessage];
CREATE TABLE TemplateMessage (
    PID         INT IDENTITY (1, 1) PRIMARY KEY
  , ToAllUser   BIT           NOT NULL DEFAULT 1
  , WebChatID   VARCHAR(64)   NOT NULL UNIQUE
  , Message     VARCHAR(1024) NOT NULL UNIQUE
  , SendingTime DATETIME      NOT NULL DEFAULT GETDATE()
  , Status      BIT           NOT NULL DEFAULT 0
);

--.10.	推送消息记录（PushMessageRecord）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'PushMessageRecord')
  DROP TABLE [PushMessageRecord];
CREATE TABLE PushMessageRecord (
    PID          INT IDENTITY (1, 1) PRIMARY KEY
  , WebChatID    VARCHAR(64) NOT NULL
  , SentTime     DATETIME    NOT NULL
  , Status       BIT         NOT NULL DEFAULT 0
  , PollDateTime DATETIME DEFAULT NULL
);

-- 11.	关注事件推送消息表（AdvertisementInfo）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'AdvertisementInfo')
  DROP TABLE [AdvertisementInfo];
CREATE TABLE AdvertisementInfo (
    PID         INT IDENTITY (1, 1) PRIMARY KEY
  , ImgUrl      VARCHAR(255)
  , ForwardUrl  VARCHAR(255)
  , Description VARCHAR(255)
);

-- 12.	关注事件推送消息表（AdvertisedSchedule）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'AdvertisedSchedule')
  DROP TABLE [AdvertisedSchedule];
CREATE TABLE AdvertisedSchedule (
    PID       INT IDENTITY (1, 1) PRIMARY KEY
  , ShopId    VARCHAR(64)
  , AdverID   INT NOT NULL
  , Priority  INT DEFAULT 0
  , BeginTime DATETIME DEFAULT GETDATE()
  , EndTime   DATETIME
  , Status    VARCHAR(10)
);

-- 13.	关注事件推送消息表（SubcEventPushMsg）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'SubcEventPushMsg')
  DROP TABLE [SubcEventPushMsg];
CREATE TABLE SubcEventPushMsg (
    PID           INT IDENTITY (1, 1) PRIMARY KEY
  , ServiceInfoID INT         NOT NULL UNIQUE
  , Type          VARCHAR(32) NOT NULL DEFAULT 'text'
  , MsgID         INT
);

-- 14.	图文消息表（NewsMsg）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'NewsMsg')
  DROP TABLE [NewsMsg];
CREATE TABLE NewsMsg (
    PID         INT IDENTITY (1, 1) PRIMARY KEY
  , Description VARCHAR(255)
);

-- 15.	文章描述表（Article）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'Article')
  DROP TABLE [Article];
CREATE TABLE Article (
    PID         INT IDENTITY (1, 1) PRIMARY KEY
  , NewsMsgID   INT
  , Title       VARCHAR(255)
  , Description VARCHAR(255)
  , PicUrl      VARCHAR(255)
  , Url         VARCHAR(255)
);
-- 16.回复文字表（Text）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'Text')
  DROP TABLE [Text];
CREATE TABLE Text (
    PID         INT IDENTITY (1, 1) PRIMARY KEY
  , Content     VARCHAR(255)
  , Description VARCHAR(255)
);
-- 17.客户类型（ClientType）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'ClientType')
  DROP TABLE [ClientType];
CREATE TABLE ClientType (
    PID         INT IDENTITY (1, 1) PRIMARY KEY
  , Type        VARCHAR(255) NOT NULL
  , Description VARCHAR(255)
);

-- 18.	外卖地址信息（TakeOutAddress）
IF EXISTS(SELECT
            *
          FROM INFORMATION_SCHEMA.TABLES
          WHERE TABLE_NAME = 'TakeOutAddress')
  DROP TABLE [TakeOutAddress];
CREATE TABLE TakeOutAddress (
    PID         INT IDENTITY (1, 1) PRIMARY KEY
  , MemberNO    VARCHAR(64)  NOT NULL
  , Phone       VARCHAR(64)  NOT NULL
  , ClientName  VARCHAR(64)
  , Address     VARCHAR(256) NOT NULL
  , Description VARCHAR(255)
);



-- 插入新增表的部分数据
INSERT INTO RestaurantGroup (GroupName) VALUES ('柠檬树餐饮集团');
INSERT INTO RestaurantInfo (GroupID, ShopID, Name, Address, Phone, POSITION)
VALUES (1, 'ZCX', '珠江新城分店', '珠江新城华利路19号', '15989133025', '245,36');
INSERT INTO DaemonAdminInfo (RestID, StaffName, passwd) VALUES (1, 'Jasic', '123456')
INSERT INTO ServiceInfo (WebChatID, restid, URL, TOKEN, BoundDate, Status)
VALUES ('微信服务号1', 1, 'http://bassice.vicp.net/webchat/token/gh_b817172873c4', 'gh_b817172873c4', getdate(), 'A001')
INSERT INTO FansInfo (WEBCHATID, SERVICEINFOID, FanName, ADDRESS, SEX)
VALUES ('关注用户1', 1, '张雄创', '广东省广州市珠江新城华利路19号', '男');
INSERT INTO FansInfo (WEBCHATID, SERVICEINFOID, FanName, ADDRESS, SEX)
VALUES ('关注用户2', 1, '张感觉', '广东省广州市珠江新城华利路19号', '男');

INSERT INTO ClientType (Type, Description) VALUES ('学生族', '这个类型是学生');
INSERT INTO ClientType (Type, Description) VALUES ('上班族', '这个类型是上班族');
INSERT INTO ClientType (Type, Description) VALUES ('白领阶层', '这个类型是白领阶层');

INSERT INTO ClientInfo (MemberNO, password, FanInfoId, ClientName, Address)
VALUES ('15989133047', 'zxcv1234', 1, '张真名', '广东省外专真实地址');
INSERT INTO BillInfo (BILLLID, BillStatus, BillType, ClientInfoID, ConsumeTime, TotalCost, ACTUALPRICE)
VALUES ('201312271321', 0, 0, 1, GETDATE(), 100.0, 100)

INSERT INTO TemplateMessage (TOALLUSER, WEBCHATID, Message)
VALUES (0, 'Jasic', '亲爱的{USERNAME}您好，我们餐厅{RESTNAME},将于{DATE}，搞活动，抽奖送{MONEY}');
INSERT INTO BookFoodInfo (BillInfoID, FoodID, FoodCount, FoodSuggest) VALUES (1, 1, 2, '请不要放盐');
INSERT INTO BookFoodInfo (BillInfoID, FoodID, FoodCount, FoodSuggest) VALUES (1, 2, 3, '请不要放辣啊');
INSERT INTO BookFoodInfo (BillInfoID, FoodID, FoodCount, FoodSuggest) VALUES (1, 5, 1, '油盐酱醋都不要');
INSERT INTO PushMessageRecord (WEBCHATID, SENTTIME) VALUES ('jasic', GETDATE());
INSERT INTO SubcEventPushMsg (ServiceInfoID, Type, MsgID) VALUES (1, 'text', 1);
INSERT INTO NewsMsg (Description) VALUES ('图文描述');
INSERT INTO Article (NewsMsgID, Title, Description, PicUrl, Url)
VALUES (1, '测试图文消息标题1', '测试图文消息的描述1', 'http://www.hackhome.com/newimg/20139/2013091252128393.png', 'http://baidu.com');
INSERT INTO Article (NewsMsgID, Title, Description, PicUrl, Url) VALUES
  (1, '测试图文消息标题2', '测试图文消息的描述2', 'http://nuomi.xnimg.cn/upload/deal/2013/7/V_L/310542-1373616839438.jpg',
   'http://baidu.com');

INSERT INTO Text (Content, Description) VALUES ('非常欢迎关注此餐厅，更多服务请看http://www.baidu.com', '关注回复文字描述');

-- 首頁广告
TRUNCATE TABLE AdvertisedSchedule

INSERT INTO AdvertisedSchedule (ShopId, AdverID, Priority, BeginTime, Status)
VALUES ('ZCX', 1, 10, GETDATE(), 'A001');
INSERT INTO AdvertisedSchedule (ShopId, AdverID, Priority, BeginTime, Status) VALUES ('ZCX', 2, 10, GETDATE(), 'A001');
INSERT INTO AdvertisedSchedule (ShopId, AdverID, Priority, BeginTime, Status) VALUES ('ZCX', 3, 10, GETDATE(), 'A001');


TRUNCATE TABLE AdvertisementInfo

INSERT AdvertisementInfo (ImgUrl, ForwardUrl, Description) VALUES ('apple.png', 'http://google.com', '广告信息描述');
INSERT AdvertisementInfo (ImgUrl, ForwardUrl, Description) VALUES ('blackberry_10.png', 'http://google.com', '广告信息描述');
INSERT AdvertisementInfo (ImgUrl, ForwardUrl, Description) VALUES ('firefox_os.png', 'http://baidu.com', '广告信息描述');


COMMIT TRANSACTION;
-- Pragma foreign_keys=true;

SELECT
  *
FROM ServiceInfo
