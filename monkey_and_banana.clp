;; Se define estado inicial
(defrule iniciar
   =>
   (assert (estado (monkey-at A) (box-at B) (banana-at C) (on-table D) (on-box E) (has-banana no))))

;; Cambia el estado indicando que el mono esta sobre la caja 
(defrule subir-monkey
   (estado (monkey-at ?) (box-at ?) (banana-at ?) (on-table ?) (on-box ?) (has-banana no))
   =>
   (printout t "Subir al box." crlf)
   (assert (estado (monkey-at on-box) (box-at ?) (banana-at ?) (on-table ?) (on-box ?) (has-banana no))))

;; Cambia el estado indicando que el mono esta moviendo la caja
(defrule empujar-box
   (estado (monkey-at on-box) (box-at ?) (banana-at ?) (on-table ?) (on-box ?) (has-banana no))
   =>
   (printout t "Empujar el box hacia la banana." crlf)
   (assert (estado (monkey-at on-box) (box-at ?) (banana-at ?) (on-table ?) (on-box on-banana) (has-banana no))))

;; Cambia a agarrar la banana
(defrule agarrar-banana
   (estado (monkey-at on-box) (box-at ?) (banana-at ?) (on-table ?) (on-box on-banana) (has-banana no))
   =>
   (printout t "Agarrar la banana." crlf)
   (assert (estado (monkey-at on-box) (box-at ?) (banana-at ?) (on-table ?) (on-box on-banana) (has-banana yes))))

;; Cambia el estado indicando que el mono bajo de la caja
(defrule bajar-monkey
   (estado (monkey-at on-box) (box-at ?) (banana-at ?) (on-table ?) (on-box on-banana) (has-banana yes))
   =>
   (printout t "Bajar del box." crlf)
   (assert (estado (monkey-at A) (box-at ?) (banana-at ?) (on-table ?) (on-box on-banana) (has-banana yes))))

;; Cambia el estado indicando que el mono tiene la banana
(defrule fin
   (estado (monkey-at A) (box-at ?) (banana-at ?) (on-table ?) (on-box on-banana) (has-banana yes))
   =>
   (printout t "¡Problema resuelto! El mono tiene la banana." crlf))

(reset)
(run)