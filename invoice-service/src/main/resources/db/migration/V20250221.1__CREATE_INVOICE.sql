CREATE TABLE invoice_db.invoice
(
    INVOICE_ID     uuid default gen_random_uuid(),
    USER_ID        VARCHAR(200) NOT NULL,
    INVOICE_NUMBER VARCHAR(500) NOT NULL,
    PRODUCT_IDS    TEXT         NOT NULL,
    CREATE_TIME    TIMESTAMP    NOT NULL,
    UPDATE_TIME    TIMESTAMP    NOT NULL,
    CONSTRAINT INVOICE_ID_PK PRIMARY KEY (INVOICE_ID),
    CONSTRAINT USER_ID_FK FOREIGN KEY (USER_ID) REFERENCES user_db.user_record (USER_ID)
);

select USER_ID
from invoice;