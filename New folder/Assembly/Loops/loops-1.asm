.radix 16
.model small
.stack 100h
.data
    adr1 dw 7777
    adr2 dw 3333
    adr3 dw 2222
.code
    start:
          mov ax,@data
          mov ds,ax
          mov ax,adr1
          mov bx,adr2
          cmp ax,bx
          jb  comp2
          mov adr1,bx
          mov adr2,ax
    comp2:
          mov ax,adr2
          mov bx,adr3
          cmp ax,bx
          jb  comp3
          mov adr2,bx
          mov adr3,ax
    comp3:
          mov ax,adr1
          mov bx,adr2
          cmp ax,bx
          jb  term
          mov adr1,bx
          mov adr2,ax
    term: 
          mov ah,4ch
          int 21h
end start