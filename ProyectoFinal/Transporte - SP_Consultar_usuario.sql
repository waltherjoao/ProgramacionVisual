USE [Transporte]
GO
/****** Object:  StoredProcedure [dbo].[SP_Consultar_usuario]    Script Date: 17/2/2022 21:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
ALTER PROCEDURE [dbo].[SP_Consultar_usuario] 
	-- Add the parameters for the stored procedure here
	@codigoUsuario varchar(10),
	@idCodigoUsuario varchar(50) out,
	@usuario varchar(50) out,
	@clave varchar(50) out,
	@tipoUsuario varchar(50) out,
	@codError varchar(max) out,
	@Error varchar(max) out
AS
BEGIN
	try
	select @idCodigoUsuario = [codigo_usuario], 
		   @usuario = [usuario], 
		   @clave = [clave],
		   @tipoUsuario = [factor1]
	from tbl_usuarios
	where codigo_usuario = @codigoUsuario


End try

Begin catch	       
	     Select @codError=Error_number()
		 Select @Error=ERROR_MESSAGE()
	 
end catch