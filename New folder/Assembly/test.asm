.model small 
.stack 100h 

.data
    a             dw 20h
    b             db 33h
    c             db 40h
    d             dw 11h
    memoryAddress dw ?

.code
main PROC
         mov ax, @data
         mov ds, ax

         mov al, b                  ; Moving al into b
         mov bl, c                  ; Moving bl into c, in order to multiply
         mul bl                     ; Multiplying b with c
         cbw                        ; Converting db(8 byte) type into dw( 16 byte)
         add ax, a                  ; Adding a into b*c, now using ax instead of al because a is type dw

         mov ax, b                  ; Moving now ax into b, because b is type db and first has to be converted to dw
         cbw                        ; Converting b from db to dw(8 bytes to 16 bytes)
         mov bx, d                  ; Moving bx into d, in order to divide
         div bx, ax                 ; Dividing d with b

         sub al, ax                 ; Completing (a+b*c) - d/b , (a+b*c) being al, and d/b being ax

         mov bx, a                  ; Moving now bx into a, in order to do a + d
         add bx, d                  ; a + d
         mov [memoryAddress], bx    ; Moving the result of a+d to the memory address

         mov al, [memoryAddress]    ; Now moving al, the result of (a+b*c) - d/b, into the memory address given by the sum a+d
         
         mov ax, 4ch                ; The last two lines are for ending the program
         int 21h
end main 
main ENDP