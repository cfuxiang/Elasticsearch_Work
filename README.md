# Elasticsearch Work

Using jest as the facade!

Several benefits rather than using the native elasticsearch api

- the api keeps changing! e.g. in the latest version 2.3.2, nodeBuilder() is gone
- it will handle the changing apis e.g. if different nodes in the cluster use different api versions, you do need to worry about them
- it has some nice features e.g. java beans!
- I was about to create a similar work but since it has been done, I do not want to reinvent the wheel

For some of the methods such as creating and restoring snapshots, I have used the native APIs instead. Apparantly, there's no such features in jest.