(defrule iniciar
   =>
   (assert (estado (monkey-at A) (box-at B) (banana-at C) (on-table D) (on-box E) (has-banana no))))

(defrule subir-monkey
   (estado (monkey-at ?) (box-at ?) (banana-at ?) (on-table ?) (on-box ?) (has-banana no))
   =>
   (printout t "Subir al box." crlf)
   (assert (estado (monkey-at on-box) (box-at ?) (banana-at ?) (on-table ?) (on-box ?) (has-banana no))))

(defrule empujar-box
   (estado (monkey-at on-box) (box-at ?) (banana-at ?) (on-table ?) (on-box ?) (has-banana no))
   =>
   (printout t "Empujar el box hacia la banana." crlf)
   (assert (estado (monkey-at on-box) (box-at ?) (banana-at ?) (on-table ?) (on-box on-banana) (has-banana no))))

(defrule agarrar-banana
   (estado (monkey-at on-box) (box-at ?) (banana-at ?) (on-table ?) (on-box on-banana) (has-banana no))
   =>
   (printout t "Agarrar la banana." crlf)
   (assert (estado (monkey-at on-box) (box-at ?) (banana-at ?) (on-table ?) (on-box on-banana) (has-banana yes))))

(defrule bajar-monkey
   (estado (monkey-at on-box) (box-at ?) (banana-at ?) (on-table ?) (on-box on-banana) (has-banana yes))
   =>
   (printout t "Bajar del box." crlf)
   (assert (estado (monkey-at A) (box-at ?) (banana-at ?) (on-table ?) (on-box on-banana) (has-banana yes))))

(defrule fin
   (estado (monkey-at A) (box-at ?) (banana-at ?) (on-table ?) (on-box on-banana) (has-banana yes))
   =>
   (printout t "¡Problema resuelto! El mono tiene la banana." crlf))

(reset)
(run)