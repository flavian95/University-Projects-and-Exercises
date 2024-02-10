.model small
.data
    buffer db 25 dup(?)
.code
main proc

              mov  cx, 250
              lea  di, buffer
              mov  al, 10

    fill_loop:
              mov  [di], al
              add  al, 10
              inc  di
              loop fill_loop

              mov  al, 4ch
              int  21h
                           
main endp

end main