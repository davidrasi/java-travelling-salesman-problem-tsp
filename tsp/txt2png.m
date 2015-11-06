%% REPRESENTACION DE LA SALIDA Y GUARDAR EN .PNG
% @davidramirezsierra
clear all
[archivo,ruta]=uigetfile('*.txt','ABRIR ARCHIVO');
if archivo==0
    return;
else
fid =fopen([ruta archivo],'r');
A=textscan(fid,'%f %f','headerlines',2);%Lee a partir de la 2º linea
A=cell2mat(A);
fclose(fid);
x=A(:,1);
y=A(:,2);
plot(x,y,'-+');
title('PROBLEMA DEL VIAJANTE algo # @davidramirezsierra')
ylabel('coordenada Y'); 
xlabel('coordenada X');
grid on
grid minor
print('sAlgo_nombre','-dpng')
end