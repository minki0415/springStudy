CREATE TABLE STUDENT (
    STUDENT_ID INT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    MAJOR_ID INT(5) UNSIGNED,
    STUDENT_NAME VARCHAR(255) NOT NULL,
    PRIMARY KEY (STUDENT_ID)
);

CREATE TABLE MAJOR (
    MAJOR_ID INT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    MAJOR_NAME VARCHAR(255),
    PRIMARY KEY(MAJOR_ID)
);

ALTER TABLE STUDENT 
ADD CONSTRAINT FK_STUDENT_MAJOR 
FOREIGN KEY (MAJOR_ID)
REFERENCES MAJOR(MAJOR_ID);

INSERT INTO MAJOR(MAJOR_NAME) VALUES("CS");

INSERT STUDENT(MAJOR_ID, STUDENT_NAME) VALUES (1, "KIM");
INSERT STUDENT(MAJOR_ID, STUDENT_NAME) VALUES (1, "CHOI");

SELECT M.*, S.STUDENT_NAME
FROM STUDENT S JOIN MAJOR M ON S.MAJOR_ID = M.MAJOR_ID
WHERE S.STUDENT_ID = 1;