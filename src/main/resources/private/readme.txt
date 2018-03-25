//generate key store sec_keystore.jks having password sec_password with api_key having password India@123 with validity 365 days
keytool -genkey -keyalg RSA -alias api_key -keypass India@123 
-keystore sec_keystore.jks -storepass sec_password -validity 365

output : 
C:\LEARNING\rest_with_security\src\main\resources\private>keytool -genkey -keyalg RSA -alias api_key -keypass India@123 -keystore sec_keystore.jks -storepass sec_password -validity 365
What is your first and last name?
  [Unknown]:  shailendra singh
What is the name of your organizational unit?
  [Unknown]:  hcl
What is the name of your organization?
  [Unknown]:  hcl
What is the name of your City or Locality?
  [Unknown]:  noida
What is the name of your State or Province?
  [Unknown]:  up
What is the two-letter country code for this unit?
  [Unknown]:  IN
Is CN=shailendra singh, OU=hcl, O=hcl, L=noida, ST=up, C=IN correct?
  [no]:  yes

Warning:
The JKS keystore uses a proprietary format. It is recommended to migrate to PKCS12 which is an industry standard format using "keytool -importkeystore -srckeystore sec_keystore.jks -destkeystore sec_keystore.jks -deststoretype pkcs12".