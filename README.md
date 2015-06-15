# Alfresco NTLMv1 MD4 password hash generator
This tiny tool generates the NTMLv1 MD4 hash of any string so you can
overwrite the admin password in the database: 

1. Generate the hash of your desired password (for example password "admin"):
  * ```java -jar alfresco-password-hash-generator-1.0.0-beta-1.jar "admin"```
2. Overwrite the current admin password as described here:
  * http://docs.alfresco.com/4.2/concepts/admin-password.html


Tested on Alfresco:
* 4.2.2
