CREATE OR REPLACE TABLE `Category` (
  `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `active` bit(1) DEFAULT NULL,
  `createdAt` datetime(6) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `priority` bigint(20) DEFAULT NULL
);

CREATE OR REPLACE TABLE `Customer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `createdAt` datetime(6) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `showCustomer` bit(1) DEFAULT NULL
);

CREATE OR REPLACE TABLE `CustomerDetails` (
  `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `createdAt` datetime(6) NOT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `updatedAt` datetime(6) NOT NULL,
  `categoryId` bigint(20) DEFAULT NULL,
  `customerId` bigint(20) DEFAULT NULL
);