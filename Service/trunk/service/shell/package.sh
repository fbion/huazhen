#!/bin/sh

ENV=$1

cd ../api-baseInfo
mvn clean
mvn deploy
cd ../api-customer
mvn clean
mvn deploy
cd ../api-employee
mvn clean
mvn deploy
cd ../api-permission
mvn clean
mvn deploy
cd ../api-product
mvn clean
mvn deploy
cd ../api-report
mvn clean
mvn deploy
cd ../api-sales
mvn clean
mvn deploy

cd ../service-baseInfo
mvn clean package -P$ENV
cp target/service-baseInfo.war ../

cd ../service-customer
mvn clean package -P$ENV
cp target/service-customer.war ../

cd ../service-employee
mvn clean package -P$ENV
cp target/service-employee.war ../

cd ../service-permission
mvn clean package -P$ENV
cp target/service-permission.war ../

cd ../service-product
mvn clean package -P$ENV
cp target/service-product.war ../

cd ../service-report
mvn clean package -P$ENV
cp target/service-report.war ../

cd ../service-sales
mvn clean package -P$ENV
cp target/service-sales.war ../