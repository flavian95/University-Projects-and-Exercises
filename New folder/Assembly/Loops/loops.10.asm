.model small
.data
    buffer dw 10 dup(?)
.code
main proc
              mov  cx, 20
              lea  di, buffer
              mov  ax, 200h

    fill_loop:
              mov  [di], ax
              sub  ax, 10
              inc  di
              loop fill_loop

              mov  ax, 4Ch
              int  21h
main endp

end main