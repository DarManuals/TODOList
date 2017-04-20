#upstream back {
#       server localhost:8080;
#       server localhost:8080;
#}
# {{.Address}}

upstream front {
least_conn;
{{range service "js-80"}}server localhost:{{.Port}} max_fails=3 fail_timeout=60 weight=1;
{{else}}server 127.0.0.1:65535; # force a 502{{end}}
}


upstream back {
least_conn;
{{range service "java"}}server localhost:{{.Port}} max_fails=3 fail_timeout=60 weight=1;
{{else}}server 127.0.0.1:65535; # force a 502{{end}}
}

server {
        listen 80;

        root /var/www/app;
        index index.html index.htm;

        server_name localhost;

        location / {
                proxy_pass http://front;
        }

        location /app/ {
                proxy_pass http://back;
        }

}

