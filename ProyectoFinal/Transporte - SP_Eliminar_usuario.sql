USE [Transporte]
GO
/****** Object:  StoredProcedure [dbo].[SP_Eliminar_usuario]    Script Date: 17/2/2022 21:39:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Gabriel,,Name>
-- Create date: <Create Date,,>
-- Description:	<SP_Eliminar_usuario,>
-- =============================================
ALTER PROCEDURE [dbo].[SP_Eliminar_usuario] 
	@codigo_usuario varchar(10), 
	@salida varchar(max) out,
	@codError varchar(max) out,
	@Error varchar(max) out
AS
BEGIN try
	if exists (select * from tbl_usuarios where codigo_usuario = @codigo_usuario and estado = 'Activo')
		begin
			Delete from tbl_usuarios where codigo_usuario= @codigo_usuario		
			select @salida='El Registro con id: '+ @codigo_usuario + ' ha sido eliminado'
			end
	else
		begin
			 --select 'El Usuario: ' + @codigo_usuario + ' ya existe'
			 select @salida='El Usuario: ' + @codigo_usuario + ' ya no existe'+ 'su estado es'+ 
			 (select estado from tbl_usuarios where codigo_usuario= @codigo_usuario)
		end
	
End try

Begin catch	       
	     Select @codError=Error_number()
		 Select @Error=ERROR_MESSAGE()
	 
end catch

