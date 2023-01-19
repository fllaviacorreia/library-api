CREATE TABLE IF NOT EXISTS borrowing(
	id BIGINT NOT NULL AUTO_INCREMENT,
	id_book BIGINT NOT NULL,
	id_user BIGINT NOT NULL,
	date_time_borrowing DATETIME NOT NULL,
	date_time_borrowing_expiration DATETIME NOT NULL,
	date_time_return DATETIME NOT NULL,
		
	PRIMARY KEY (id)
	
)
ALTER TABLE borrowing ADD CONSTRAINT fk_book
	FOREIGN KEY (id_book) REFERENCES book (id)
	
ALTER TABLE borrowing ADD CONSTRAINT fk_user
	FOREIGN KEY (id_user) REFERENCES user (id)