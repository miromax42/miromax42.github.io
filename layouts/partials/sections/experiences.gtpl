{{ $sectionID := replace (lower .section.name) " " "-"  }}
{{ if .section.id }}
  {{ $sectionID = .section.id }}
{{ end }}

<div class="container-fluid anchor pb-5 experiences-section">
  {{ if not (.section.hideTitle) }}
    <h1 class="text-center">
        <span id="{{ $sectionID }}"></span>{{ .section.name }}</h1>
  {{ else }}
    <h1 class="text-center" style="display: none">
        <span id="{{ $sectionID }}"></span>{{ .section.name }}</h1>
  {{ end }}

  <div class="container timeline text-justify">
   {{ $totalExperiences:= len .experiences }}
   {{ range $index,$experience:= .experiences }}
     {{ if eq (mod $index 2) 0 }}
       <div class="row align-items-center  d-flex">
         {{ partial "sections/experiences/vertical-line.gtpl" $index }}
         {{ partial "sections/experiences/experience-info.gtpl" $experience }}
       </div>
     {{else}}
       <div class="row align-items-center justify-content-end d-flex">
         {{ partial "sections/experiences/experience-info.gtpl" $experience }}
         {{ partial "sections/experiences/vertical-line.gtpl" $index }}
       </div>
     {{ end }}
     {{ if lt $index (sub $totalExperiences 1) }}
       {{ partial "sections/experiences/horizontal-line.gtpl" $index }}
     {{ end }}
   {{ end }}
  </div>
</div>
