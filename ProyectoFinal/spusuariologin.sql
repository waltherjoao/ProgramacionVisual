USE [Transporte]
GO
/****** Object:  StoredProcedure [dbo].[spusuariologin]    Script Date: 3/2/2022 21:27:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
ALTER PROCEDURE [dbo].[spusuariologin] 
	-- Add the parameters for the stored procedure here
	@usuario varchar(50), 
	@pass varchar(50),
	@salida varchar(max) out
AS
BEGIN
	if exists (select * from tbl_usuarios where usuario = @usuario and clave = @pass)
	begin
	     --select 'El Usuario: ' + @codigo_usuario + ' ya existe'
		 select @salida='Ok'
	end
	else
	begin
	     --select 'El Usuario: ' + @codigo_usuario + ' ya existe'
		 select @salida='Error'
	end
END
