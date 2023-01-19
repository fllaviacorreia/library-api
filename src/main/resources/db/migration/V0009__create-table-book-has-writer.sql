CREATE TABLE IF NOT EXISTS book_has_writer(
	id_book BIGINT NOT NULL,
	id_writer BIGINT NOT NULL,
		
	PRIMARY KEY (id_writer, id_book)
	
)

ALTER TABLE book_has_writer ADD CONSTRAINT fk_book
	FOREIGN KEY (id_book) REFERENCES book (id)
	
ALTER TABLE book_has_writer ADD CONSTRAINT fk_writer
	FOREIGN KEY (id_writer) REFERENCES writer (id)
