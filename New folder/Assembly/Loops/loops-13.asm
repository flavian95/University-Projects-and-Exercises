.model small
.data
    buffer dw 80 dup(?)
.code
main proc
              mov  cx, 800
              lea  di, buffer
              mov  ax, 10

    fill_loop:
              mov  [di], ax
              add  ax, 10
              inc  di
              loop fill_loop

              mov  ax, 4ch
              int  21h
        
main endp

end main