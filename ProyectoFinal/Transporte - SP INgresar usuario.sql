USE [Transporte]
GO
/****** Object:  StoredProcedure [dbo].[SP_Ingresar_Usuario]    Script Date: 17/2/2022 21:39:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--If exists (select * from sys.objects Where name in ('SP_Ingresar_Usuario')) Drop procedure SP_Ingresar_Usuario

ALTER PROCEDURE [dbo].[SP_Ingresar_Usuario]
	-- Parametros de entrada
	@codigo_usuario varchar(10), 
	@usuario varchar(20), 
	@clave varchar(20), 
	@factor1 varchar(40) , 
	@factor2 varchar(40) , 
	--Campos de auditoria
	@estado varchar(10),
	@fecha_actualizacion date, 
	@usuario_creacion varchar(20), 
	@salida varchar(max) out,
	@codError varchar(max) out,
	@Error varchar(max) out
	
AS
BEGIN try
	
	if exists (select * from tbl_usuarios where codigo_usuario = @codigo_usuario)
	begin
	     --select 'El Usuario: ' + @codigo_usuario + ' ya existe'
		 select @salida='El Usuario: ' + @codigo_usuario + ' ya existe'
	end
	else
	begin
		insert into tbl_usuarios(codigo_usuario,usuario,clave,factor1,factor2,estado,fecha_actualizacion,usuario_creacion)
		values (@codigo_usuario,@usuario,@clave,@factor1,@factor2,@estado,@fecha_actualizacion,@usuario_creacion)
		select @salida='El Usuario: ' + @codigo_usuario + ' ha sido creado exitosamente'
	end

END try
Begin catch	       
	     Select @codError=Error_number()
		 Select @Error=ERROR_MESSAGE()
	    --select convert(varchar,Error_number()) +'     '+ERROR_MESSAGE()
		--select @salida+ERROR_MESSAGE()
end catch
