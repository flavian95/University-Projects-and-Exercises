.model small
.data
    buffer dw 100 dup(?)
.code
main proc
              mov  cx, 500
              lea  di, buffer
              mov  ax, 5

    fill_loop:

              mov  [di], ax
              dec  ax, 10
              inc  di
              loop fill_loop

              mov  ax, 4Ch
              int  21h
        
main endp

end main