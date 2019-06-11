CREATE TABLE IF NOT EXISTS datetime (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  dateId varchar(255) DEFAULT NULL,
  dateName varchar(255),
  dateStandart datetime DEFAULT NULL,
  calulationYear bigint(20),
  calulationMonth bigint(20),
  calulationDay bigint(20),
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;