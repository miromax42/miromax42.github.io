{{ if gt (len .positions) 1 }}
  {{ partial "sections/experiences/multiple-positions.gtpl" . }}
{{ else }}
  {{ partial "sections/experiences/single-position.gtpl" . }}
{{ end }}
