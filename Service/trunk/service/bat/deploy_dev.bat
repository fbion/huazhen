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

cd..\service-baseInfo\
call mvn tomcat7:redeploy -Pdev

cd..\service-customer
call mvn tomcat7:redeploy -Pdev

cd..\service-employee
call mvn tomcat7:redeploy -Pdev

cd..\service-permission
call mvn tomcat7:redeploy -Pdev

cd..\service-product
call mvn tomcat7:redeploy -Pdev

cd..\service-report
call mvn tomcat7:redeploy -Pdev

cd..\service-sales
call mvn tomcat7:redeploy -Pdev
echo "+++++++++++++++++++++++++++++++++++++++++"
echo "------------package success!!!-----------"
echo "+++++++++++++++++++++++++++++++++++++++++"