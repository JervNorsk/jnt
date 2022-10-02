key http_request_id;

default
{
    state_entry()
    {
        http_request_id = llHTTPRequest("https://3000-jervnorsk-jnt-tqtaybdi6ld.ws-eu67.gitpod.io/", [], "");
    }

    http_response(key request_id, integer status, list metadata, string body)
    {
        if(request_id != http_request_id) return;

        vector COLOR_BLUE = <0.0, 0.0, 1.0>;
        float  OPAQUE     = 1.0;

        llSetText(body, COLOR_BLUE, OPAQUE);
    }
}
