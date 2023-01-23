CREATE TABLE IF NOT EXISTS book(
	id BIGINT NOT NULL AUTO_INCREMENT,
	title VARCHAR(200) NOT NULL,
	date_publication DATE NOT NULL,
	number_copies INT NOT NULL,
	id_publishing_company INT NOT NULL,
		
	PRIMARY KEY (id)
	
)
ALTER TABLE book ADD CONSTRAINT fk_publishing_companies
	FOREIGN KEY (id_publishing_company) REFERENCES publishing-companies (id)