# mongodb-kerberos
To use different principal to connect to mongodb as discussed in the following link:
https://www.mongodb.com/blog/post/setting-up-java-applications-to-communicate-with

Added some changes to make it work with JAAS and connect to database using different principal than who runs the code.

The following helped to fix some issues:
https://stackoverflow.com/questions/33829017/gssexception-no-valid-credentials-provided-mechanism-level-failed-to-find-any
