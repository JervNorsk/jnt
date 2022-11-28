key http_request_id;

default {
    state_entry()
    {
        http_request_id = llHTTPRequest("http://ec2-16-170-164-158.eu-north-1.compute.amazonaws.com", [], "");
    }

    http_response(key request_id, integer status, list metadata, string body)
    {
        if(request_id != http_request_id) return;

        vector COLOR  = <0.0, 0.0, 0.0>;
        float  OPAQUE = 1.0;

        llSetText(body, COLOR, OPAQUE);
    }
}