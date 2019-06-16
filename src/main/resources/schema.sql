CREATE TABLE IF NOT EXISTS Datetime (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  dateId varchar(255) DEFAULT NULL,
  dateName varchar(255),
  dateStandart varchar(255),
  calulationYear bigint(20),
  calulationMonth bigint(20),
  calulationDay bigint(20),
  resultDate date,
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;