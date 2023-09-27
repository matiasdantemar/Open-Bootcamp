En Okta:

1. https://www.okta.com/
2. Login
3. applications - Created App Integration
4. Select OIDC - OpenID Connect, Web Application, next
5. configure
6. copy and paste Credentials in application.properties
7. spring.security.oauth2.client.registration.okta.client-id=
   spring.security.oauth2.client.registration.okta.client-secret=
   spring.security.oauth2.client.provider.okta.issuer-uri=