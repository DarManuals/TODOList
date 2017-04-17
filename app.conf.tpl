#upstream back {
#       server localhost:8080;
#       server localhost:8080;
#}
# {{.Address}}

upstream back {
least_conn;
{{range service "a1"}}server localhost:{{.Port}} max_fails=3 fail_timeout=60 weight=1;
{{else}}server 127.0.0.1:65535; # force a 502{{end}}
}

server {
        listen 80;

        root /var/www/app;
        index index.html index.htm;

        server_name localhost;

        location / {
                try_files $uri $uri/ =404;
        }

        location /app/ {
                proxy_pass http://back;
        }

}

