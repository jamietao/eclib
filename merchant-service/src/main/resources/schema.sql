CREATE TABLE merchants
(
 	`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
 	`name` varchar(64) NOT NULL,
 	`logo_url` varchar(256) NOT NULL,
 	`license_url` varchar(256) NOT NULL,
 	`phone` varchar(15) NOT NULL,
 	`address` varchar(64) NOT NULL,
 	`is_audit` boolean NOT NULL,
 	
 	CONSTRAINT merchants_pk PRIMARY KEY (`id`),
 	CONSTRAINT merchants_name_uq unique(`name`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;