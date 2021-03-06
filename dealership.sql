--TABLE CREATION

--drop table usr;
CREATE TABLE USR(
  user_id   INTEGER,
  username  VARCHAR(15),
  pword     VARCHAR(15),
  is_admin  INTEGER,
  CONSTRAINT unique_name UNIQUE(username)
);

drop table car;
CREATE TABLE CAR(
  car_id   INTEGER,
  make     VARCHAR(15),
  mdl      VARCHAR(15),
  payment  NUMBER(10,2),
  pay_yrs  INTEGER,
  is_owned INTEGER
);

drop table offer;
CREATE TABLE OFFER(
  offer_id INTEGER,
  usr  INTEGER,
  car   INTEGER,
  accepted INTEGER
);

--KEYS AND TRIGGERS

ALTER TABLE USR
ADD(CONSTRAINT USERPK PRIMARY KEY(user_id));

ALTER TABLE CAR
ADD(CONSTRAINT CARPK PRIMARY KEY(car_id));

ALTER TABLE OFFER
ADD(CONSTRAINT OFFERPK PRIMARY KEY(offer_id));

CREATE SEQUENCE SEQ;

CREATE OR REPLACE TRIGGER USER_INSERT
  BEFORE INSERT ON USR
  FOR EACH ROW
BEGIN
  SELECT SEQ.NEXTVAL
  INTO :new.user_id
  FROM dual;
END;
/

CREATE OR REPLACE TRIGGER CAR_INSERT
  BEFORE INSERT ON CAR
  FOR EACH ROW
BEGIN
  SELECT SEQ2.NEXTVAL
  INTO :new.car_id
  FROM dual;
END;  
/

CREATE OR REPLACE TRIGGER OFFER_INSERT
  BEFORE INSERT ON OFFER
  FOR EACH ROW
BEGIN
  SELECT SEQ3.NEXTVAL
  INTO :new.offer_id
  FROM dual;
END;  
/

--FUNCTION DEFINITION

CREATE OR REPLACE PROCEDURE MAKE_USER
(USERNAME IN VARCHAR, PWORD IN VARCHAR, IS_ADMIN IN INTEGER)
AS
BEGIN
INSERT INTO USR VALUES(SEQ.NEXTVAL, USERNAME, PWORD, IS_ADMIN);
COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE MAKE_CAR
(MAKE IN VARCHAR, MDL IN VARCHAR, PAYMENT IN NUMBER, PAY_YRS IN INTEGER, IS_OWNED IN INTEGER)
AS
BEGIN
INSERT INTO CAR VALUES(SEQ2.NEXTVAL, MAKE, MDL, PAYMENT, PAY_YRS, IS_OWNED);
COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE MAKE_OFFER
(USR IN INTEGER, CAR IN INTEGER, ACCEPTED IN INTEGER)
AS
BEGIN
INSERT INTO OFFER VALUES(SEQ3.NEXTVAL, USR, CAR, ACCEPTED);
COMMIT;
END;
/

--INITIAL DATA

EXECUTE MAKE_USER('MOHAMED', '123456', 0);
EXECUTE MAKE_USER('root', 'root', 1);
EXECUTE MAKE_CAR('HONDA', 'CIVIC', 100000, 4, 0);
EXECUTE MAKE_OFFER(48, 21, 0);

select * from usr;
select * from car;
select * from offer;