CREATE TABLE Author (
    AuthorID NUMBER PRIMARY KEY,
    Name VARCHAR2(100) NOT NULL
);

CREATE TABLE Publisher (
    PublisherID NUMBER PRIMARY KEY,
    Name VARCHAR2(100) NOT NULL
);

CREATE TABLE Book (
    InventoryNumber NUMBER PRIMARY KEY,
    Title VARCHAR2(255) NOT NULL,
    YearWritten NUMBER NOT NULL,
    LanguageWritten VARCHAR2(50) NOT NULL,
    FirstAuthorID NUMBER,
    CONSTRAINT fk_first_author FOREIGN KEY (FirstAuthorID) REFERENCES Author(AuthorID)
);

CREATE TABLE BookAuthor (
    BookID NUMBER,
    AuthorID NUMBER,
    PRIMARY KEY (BookID, AuthorID),
    CONSTRAINT fk_book FOREIGN KEY (BookID) REFERENCES Book(InventoryNumber),
    CONSTRAINT fk_author FOREIGN KEY (AuthorID) REFERENCES Author(AuthorID)
);

CREATE TABLE Copy (
    CopyID NUMBER PRIMARY KEY,
    InventoryNumber NUMBER,
    VolumeNumber NUMBER NOT NULL,
    Edition VARCHAR2(50) NOT NULL,
    PublishingHouseID NUMBER,
    NumberOfPages NUMBER NOT NULL,
    LanguageOfEdition VARCHAR2(50) NOT NULL,
    CONSTRAINT fk_inventory FOREIGN KEY (InventoryNumber) REFERENCES Book(InventoryNumber),
    CONSTRAINT fk_publisher FOREIGN KEY (PublishingHouseID) REFERENCES Publisher(PublisherID)
);

CREATE TABLE Member (
    MemberID NUMBER PRIMARY KEY,
    Name VARCHAR2(100) NOT NULL,
    Surname VARCHAR2(100) NOT NULL,
    CNP VARCHAR2(13) NOT NULL UNIQUE,
    Email VARCHAR2(100) NOT NULL UNIQUE,
    Phone VARCHAR2(15) NOT NULL,
    Address VARCHAR2(255) NOT NULL
);

CREATE TABLE Loan (
    LoanID NUMBER PRIMARY KEY,
    MemberID NUMBER,
    CopyID NUMBER,
    LoanDate DATE NOT NULL,
    ReturnDate DATE,
    Deadline DATE NOT NULL,
    CONSTRAINT fk_member FOREIGN KEY (MemberID) REFERENCES Member(MemberID),
    CONSTRAINT fk_copy FOREIGN KEY (CopyID) REFERENCES Copy(CopyID)
);

-- Creating sequences for auto-increment functionality

-- Sequence for AuthorID
CREATE SEQUENCE AuthorSeq START WITH 1 INCREMENT BY 1;

-- Sequence for PublisherID
CREATE SEQUENCE PublisherSeq START WITH 1 INCREMENT BY 1;

-- Sequence for InventoryNumber
CREATE SEQUENCE BookSeq START WITH 1 INCREMENT BY 1;

-- Sequence for CopyID
CREATE SEQUENCE CopySeq START WITH 1 INCREMENT BY 1;

-- Sequence for MemberID
CREATE SEQUENCE MemberSeq START WITH 1 INCREMENT BY 1;

-- Sequence for LoanID
CREATE SEQUENCE LoanSeq START WITH 1 INCREMENT BY 1;

-- Creating triggers to automatically increment primary keys

-- Trigger for AuthorID
CREATE OR REPLACE TRIGGER AuthorTrigger
BEFORE INSERT ON Author
FOR EACH ROW
BEGIN
  SELECT AuthorSeq.NEXTVAL INTO :NEW.AuthorID FROM DUAL;
END;

-- Trigger for PublisherID
CREATE OR REPLACE TRIGGER PublisherTrigger
BEFORE INSERT ON Publisher
FOR EACH ROW
BEGIN
  SELECT PublisherSeq.NEXTVAL INTO :NEW.PublisherID FROM DUAL;
END;

-- Trigger for InventoryNumber
CREATE OR REPLACE TRIGGER BookTrigger
BEFORE INSERT ON Book
FOR EACH ROW
BEGIN
  SELECT BookSeq.NEXTVAL INTO :NEW.InventoryNumber FROM DUAL;
END;

-- Trigger for CopyID
CREATE OR REPLACE TRIGGER CopyTrigger
BEFORE INSERT ON Copy
FOR EACH ROW
BEGIN
  SELECT CopySeq.NEXTVAL INTO :NEW.CopyID FROM DUAL;
END;

-- Trigger for MemberID
CREATE OR REPLACE TRIGGER MemberTrigger
BEFORE INSERT ON Member
FOR EACH ROW
BEGIN
  SELECT MemberSeq.NEXTVAL INTO :NEW.MemberID FROM DUAL;
END;

-- Trigger for LoanID
CREATE OR REPLACE TRIGGER LoanTrigger
BEFORE INSERT ON Loan
FOR EACH ROW
BEGIN
  SELECT LoanSeq.NEXTVAL INTO :NEW.LoanID FROM DUAL;
END;
