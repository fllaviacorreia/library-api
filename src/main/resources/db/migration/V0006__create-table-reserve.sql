CREATE TABLE IF NOT EXISTS reserve(
	id BIGINT NOT NULL AUTO_INCREMENT,
	id_book BIGINT NOT NULL,
	id_user BIGINT NOT NULL,
	date_time_reservation DATETIME NOT NULL,
	date_time_reservation_expiration DATETIME NOT NULL,
	
	PRIMARY KEY (id)
	
)
ALTER TABLE reserve ADD CONSTRAINT fk_book
	FOREIGN KEY (id_book) REFERENCES book (id)
	
ALTER TABLE reserve ADD CONSTRAINT fk_user
	FOREIGN KEY (id_user) REFERENCES user (id)