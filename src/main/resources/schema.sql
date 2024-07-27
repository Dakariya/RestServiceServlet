CREATE TABLE `customer`
(
    `id`    int                              NOT NULL AUTO_INCREMENT,
    `name`  varchar(255) COLLATE utf8mb3_bin NOT NULL,
    `email` varchar(255) COLLATE utf8mb3_bin NOT NULL,
    `phone` varchar(20) COLLATE utf8mb3_bin  NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `email` (`email`)
)

CREATE TABLE `product`
(
    `id`          int                              NOT NULL AUTO_INCREMENT,
    `name`        varchar(255) COLLATE utf8mb3_bin NOT NULL,
    `description` varchar(255) COLLATE utf8mb3_bin NOT NULL,
    `price`       decimal(10, 2)                   NOT NULL,
    `stock`       int                              NOT NULL,
    PRIMARY KEY (`id`)
)

CREATE TABLE `customer_products`
(
    `customer_id` int NOT NULL,
    `product_id`  int NOT NULL,
    PRIMARY KEY (`customer_id`, `product_id`),
    KEY           `product_id` (`product_id`),
     FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
     FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
)

INSERT INTO customer VALUES (    2,'Ivan','ivan@example.com', '7 999 999-99-88',
4,'Ivan','ivan@ivanov.com', '79085347316',
5,'Svetlana,svet.lana.com', '7893859',
6,'Kristina,kris@tina.com', '780838',
7,'Roman,roman@example.com', '8940048',
8,'John Doe,john.doe@example.com','123-456-7890'
26,'Igor','igor.doe@example.com','123-456-7890');

INSERT INTO customer VALUES (  1,'sweets','tasty',45.50,7
3,'watermelon','yellow',56.60,10
4,'Coca cola','original taste',10.00,15
5,'Coca cola','original taste',10.00,15
6,'Coca cola','original taste',10.00,15
7,'Coca cola','original taste',10.00,15
8,'Coca cola','original taste',10.00,15
9,'Coca cola','original taste',10.00,15
10,'Coca cola','original taste',10.00,15
11,'Coca cola','original taste',10.00,15
12,'Coca cola','original taste',10.00,15
14,'Coca cola','original taste',10.00,15
15,'Coca cola','original taste',10.00,15
16,'Coca cola','original taste',10.00,15
17,'Coca cola','original taste',10.00,15
18,'Coca cola','original taste',10.00,15
19,'Coca cola','original taste',10.00,15
20,'Coca cola','original taste',10.00,15
21,'Coca cola','original taste',10.00,15
22,'Coca cola','original taste',10.00,15
23,'Coca cola','original taste',10.00,15
24,'Coca cola','original taste',10.00,15
25,'Coca cola','original taste',10.00,15);


INSERT INTO customer_products VALUES (2,1
4,1
5,1
2,3);


