set ENV=%1

cd..\api-baseInfo
call mvn clean
call mvn deploy
cd..\api-customer
call mvn clean
call mvn deploy
cd..\api-employee
call mvn clean
call mvn deploy
cd..\api-permission
call mvn clean
call mvn deploy
cd..\api-product
call mvn clean
call mvn deploy
cd..\api-report
call mvn clean
call mvn deploy
cd..\api-sales
call mvn clean
call mvn deploy

cd..\service-baseInfo
call mvn clean package -P%ENV%
copy target\service-baseInfo.war ..\

cd..\service-customer
call mvn clean package -P%ENV%
copy target\service-customer.war ..\

cd..\service-employee
call mvn clean package -P%ENV%
copy target\service-employee.war ..\

cd..\service-permission
call mvn clean package -P%ENV%
copy target\service-permission.war ..\

cd..\service-product
call mvn clean package -P%ENV%
copy target\service-product.war ..\

cd..\service-report
call mvn clean package -P%ENV%
copy target\service-report.war ..\

cd..\service-sales
call mvn clean package -P%ENV%
copy target\service-sales.war ..\
echo "+++++++++++++++++++++++++++++++++++++++++"
echo "------------package success!!!-----------"
echo "+++++++++++++++++++++++++++++++++++++++++"