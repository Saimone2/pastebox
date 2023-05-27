# Pastebox

Implementation of the test task.

It is necessary to design and implement a backend (REST API) for the service. The service allows you to upload pieces of text/code ("paste") and get a short link to them, which you can send to other people.

When loading "paste" the user specifies:
1. The period during which the "paste" will be available via the link (expiration time) 10 min., 1 hour. 3 hours, 1 day, 1 week, 1 month, without limitation, after the expiration of the term, access to the "paste" is impossible, including the author

2. Access restriction:
public - available to everyone
unlisted - available only by link

For the downloaded paste, a short link of the form is displayed:
http:// domain /(some random hash), e.g. /ab12cd34

Users can get information in the last 10 uploaded public "pastes".
