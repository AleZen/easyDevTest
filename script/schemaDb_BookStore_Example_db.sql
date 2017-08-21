--
-- Database: `BookStore_Example_db`
--

CREATE TABLE users (	
    "username" VARCHAR2(30 BYTE), 
    "pass" VARCHAR2(32 BYTE), 
    "id" NUMBER(38,0)
);

CREATE UNIQUE INDEX "USERS_PK" ON users ("id") ;
ALTER TABLE users MODIFY ("id" NOT NULL ENABLE);
ALTER TABLE users ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("id") ENABLE;
  
INSERT INTO users ("username", "pass", "id") VALUES ('admin', '1a1dc91c907325c69271ddf0c944bc72', 1);

CREATE TABLE roles (	
    "role" VARCHAR2(30 BYTE), 
    "_user" NUMBER(38, 0), 
    "id" NUMBER(38,0)
);

CREATE UNIQUE INDEX "ROLES_PK" ON roles ("id");
ALTER TABLE roles ADD CONSTRAINT "ROLES_PK" PRIMARY KEY ("id");
ALTER TABLE roles MODIFY ("id" NOT NULL ENABLE);
ALTER TABLE roles ADD CONSTRAINT "ROLES_FK1" FOREIGN KEY ("_user")
	  REFERENCES users ("id") ENABLE;

INSERT INTO roles ("role", "_user", "id") VALUES ('ADMIN', '1', 1);


-- ENTITIES

--
-- Struttura della tabella `Author`
--

    CREATE TABLE Author (	
        "gender" varchar(30),
        "name" varchar(30),
        "surname" varchar(30),
        
        -- RELAZIONI
        
        "id" NUMBER(38,0)
    );
    
    
    CREATE UNIQUE INDEX "Author_PK" ON Author ("id");
    ALTER TABLE Author ADD CONSTRAINT "Author_PK" PRIMARY KEY ("id");
    ALTER TABLE Author MODIFY ("id" NOT NULL ENABLE);

--
-- Struttura della tabella `Book`
--

    CREATE TABLE Book (	
        "title" varchar(30),
        "year" numeric,
        
        -- RELAZIONI
        "_author" NUMBER(38, 0), 
        
        "id" NUMBER(38,0)
    );
    
    
    CREATE UNIQUE INDEX "Book_PK" ON Book ("id");
    ALTER TABLE Book ADD CONSTRAINT "Book_PK" PRIMARY KEY ("id");
    ALTER TABLE Book MODIFY ("id" NOT NULL ENABLE);


-- RELATIONS

    -- RELATIONS TABLE Author
    
        
        
        
        



    -- RELATIONS TABLE Book
    
        
        -- foreign key _author
        ALTER TABLE Book ADD CONSTRAINT "Book__author" FOREIGN KEY ("_author")
        	  REFERENCES Author ("id") ON DELETE SET NULL ENABLE;
        
        
        
        



