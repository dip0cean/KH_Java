SELECT * FROM POST;
SELECT * FROM MEMBER;

CREATE TABLE POST (
POST_NO NUMBER PRIMARY KEY,
POST_ID REFERENCES MEMBER(MEMBER_ID) ON DELETE CASCADE,
POST_SUB VARCHAR2(6) DEFAULT '일반' CHECK(POST_SUB IN('공지','일반','정보','질문')),
POST_TITLE VARCHAR2(300) NOT NULL,
POST_CONTENT VARCHAR2(4000) NOT NULL,
POST_DATE DATE DEFAULT SYSDATE NOT NULL,
POST_HITS NUMBER DEFAULT 0 NOT NULL,
SUPER_NO REFERENCES POST(POST_NO) ON DELETE CASCADE,
GROUP_NO NUMBER NOT NULL,
DEPTH NUMBER NOT NULL
);

DROP TABLE POST;
DROP TABLE REPLY;
DROP SEQUENCE POST_SEQ;
DROP SEQUENCE REPLY_SEQ;


--post TABLE 항목 추가
SUPER_NO NOT NULL REFERENCES POST(POST_NO) ON DELETE CASCADE;
GROUP_NO NUMBER NOT NULL;
DEPTH NUMBER NOT NULL;

SELECT * FROM POST 
WHERE POST_SUB='일반'
START WITH SUPER_NO IS NULL
CONNECT BY PRIOR POST_NO=SUPER_NO  
ORDER SIBLINGS BY GROUP_NO DESC, POST_NO ASC;

SELECT * FROM POST WHERE INSTR(POST_ID,(SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_NICK = '김멋찐')) > 0 ORDER BY POST_NO DESC , POST_ID ASC;
SELECT * FROM POST WHERE POST_SUB = '공지' AND INSTR(POST_ID,(SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_NICK = '김멋찐')) > 0;

SELECT * FROM POST 
CONNECT BY PRIOR POST_NO=SUPER_NO 
START WITH SUPER_NO 
IS NULL 
ORDER SIBLINGS BY GROUP_NO DESC, POST_NO ASC, POST_DATE DESC;

SELECT * FROM POST CONNECT BY PRIOR POST_NO=SUPER_NO START WITH SUPER_NO IS NULL ORDER SIBLINGS BY GROUP_NO DESC, POST_NO ASC;

-- Top N Query : 원하는 구간을 조회하기 위한 SQL 구문 형태
SELECT * FROM (SELECT ROWNUM RN, T.* FROM (SELECT * FROM POST CONNECT BY PRIOR POST_NO=SUPER_NO START WITH SUPER_NO IS NULL ORDER SIBLINGS BY GROUP_NO DESC, POST_NO ASC) T	) WHERE RN BETWEEN 1 AND 10;


SELECT * FROM POST WHERE INSTR(POST_TITLE, ? ) > 0 AND POST_SUB = ? CONNECT BY PRIOR POST_NO=SUPER_NO START WITH SUPER_NO IS NULL ORDER SIBLINGS BY GROUP_NO DESC, POST_NO ASC;

SELECT * FROM POST WHERE POST_SUB = ? AND INSTR(POST_ID,(SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_NICK = ? )) > 0;

SELECT COUNT(*) FROM POST WHERE POST_SUB = '일반' AND INSTR(POST_TITLE,'테스트') > 0;
SELECT COUNT(*) FROM POST;
SELECT COUNT(*) FROM POST WHERE POST_ID = (SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_NICK = '운영자');























