# Elasticsearch Work

Using jest as the facade!

Several benefits rather than using the native elasticsearch api

- the api keeps changing! e.g. in the latest version 2.3.2, nodeBuilder() is gone
- it will handles the changing apis e.g. if different nodes in the cluster uses different api versions, you do need to worry about
- it has some nice features e.g. java beans!
- I was about to create a similar work but since it has been done, I do not want to reinvent the wheel

