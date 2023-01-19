CREATE TABLE IF NOT EXISTS book_has_category(
	id_book BIGINT NOT NULL,
	id_category BIGINT NOT NULL,
		
	PRIMARY KEY (id_category, id_book)
	
)

ALTER TABLE book_has_category ADD CONSTRAINT fk_book
	FOREIGN KEY (id_book) REFERENCES book (id)
	
ALTER TABLE book_has_category ADD CONSTRAINT fk_category
	FOREIGN KEY (id_category) REFERENCES category (id)