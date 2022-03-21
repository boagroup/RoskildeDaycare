USE Daycare;

CREATE TABLE Parent(
    ParentId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(255),
    LastName VARCHAR(255)
);

CREATE TABLE Children(
    ChildId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    GroupId INT,
    BirthDate DATE NOT NULL,
    FOREIGN KEY (GroupId)
        REFERENCES `Groups`(GroupId)
        ON DELETE SET NULL
);

CREATE TABLE `Groups`(
    GroupId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255),
    Grade INT
);

CREATE TABLE Contact(
    ParentId INT NOT NULL,
    TelNumber INT(11),
    Email VARCHAR(255),
    FOREIGN KEY (ParentId)
        REFERENCES Parent(ParentId)
        ON DELETE CASCADE
);

CREATE TABLE Waiting(
    WaitOrder INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ChildId INT NOT NULL,
    FOREIGN KEY (ChildId)
        REFERENCES Children(ChildId)
        ON DELETE CASCADE
);

CREATE TABLE Staff(
  StaffId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  FirstName VARCHAR(255),
  LastName VARCHAR(255)
);

CREATE TABLE Rooms(
    RoomId INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE Schedule(
    Date DATE,
    GroupId INT NOT NULL,
    StaffId INT NOT NULL,
    RoomId INT NOT NULL,
    FOREIGN KEY (GroupId)
         REFERENCES `Groups`(GroupId)
         ON DELETE CASCADE,
    FOREIGN KEY (StaffId)
        REFERENCES Staff(StaffId)
        ON DELETE CASCADE,
    FOREIGN KEY (RoomId)
        REFERENCES Rooms(RoomId)
        ON DELETE CASCADE
);

CREATE TABLE Relation(
    ChildId INT NOT NULL,
    ParentId INT NOT NULL,
    FOREIGN KEY (ChildId)
        REFERENCES Children(ChildId)
        ON DELETE CASCADE,
    FOREIGN KEY (ParentId)
        REFERENCES Parent(ParentId)
        ON DELETE CASCADE
);
