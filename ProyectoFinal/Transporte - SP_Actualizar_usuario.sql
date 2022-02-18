USE [Transporte]
GO
/****** Object:  StoredProcedure [dbo].[SP_Actualizar_usuario]    Script Date: 17/2/2022 21:41:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Gabriel,,Name>
-- Create date: <Create Date,,>
-- Description:	<SP_actualizar_usuario,,>
-- =============================================
ALTER PROCEDURE [dbo].[SP_Actualizar_usuario] 
	@codigo_usuario varchar(10), 
	@usuario varchar(20), 
	@clave varchar(20), 
	@factor1 varchar(40) , 
	@factor2 varchar(40) , 
	--Campos de auditoria
	@estado varchar(10),
	@usuario_creacion varchar(20), 
	@salida varchar(max) out,
	@codError varchar(max) out,
	@Error varchar(max) out
AS
BEGIN try
select @salida='Linea 1 ' + @codigo_usuario + ' por aqui'
	if exists (select * from tbl_usuarios where codigo_usuario = @codigo_usuario)
	begin
		select @salida='Ingreso ' + @codigo_usuario + ' por aqui'
		update tbl_usuarios
		set codigo_usuario= @codigo_usuario,
		usuario= @usuario,
		clave=@clave,
		factor1=@factor1,
		factor2=@factor2,
		fecha_actualizacion = GETDATE()
		where codigo_usuario= @codigo_usuario

		select @salida='El Usuario: ' + @codigo_usuario + ' ha sido actualizado'
	end
	else
	begin
	     --select 'El Usuario: ' + @codigo_usuario + ' ya existe'
		 select @salida='El Usuario: ' + @codigo_usuario + 'no existe, por ende no se puede actualizar'
	end


End try

Begin catch	       
	     Select @codError=Error_number()
		 Select @Error=ERROR_MESSAGE()
	 
end catch