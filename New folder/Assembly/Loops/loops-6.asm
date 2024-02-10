.model small
.data
    buffer db 20 dup(?)

.code
main proc
              mov  cx, 20
              lea  di, buffer
              mov  al, 33h

    fill_loop:
              mov  [di], al
              inc  di
              loop fill_loop

              mov  ah, 4Ch
              int  21h
main endp

end main
